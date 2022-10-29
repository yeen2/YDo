package com.example.demo.api.fifa.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.example.demo.util.ApiUtil;
import com.example.demo.util.StringUtil;

@Service
public class ApiFifa001Service {

	private String apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjE1NjAzNjU1NTMiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY4MjE3MjAzOSwiaWF0IjoxNjY2NjIwMDM5LCJuYmYiOjE2NjY2MjAwMzksInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.WKrB6ZQtTHV23dACkfb63SmcJCfb2wI-K88F60fpRpE";
	
	public String allMatch() throws IOException {
		
		String apiUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/matches";
		
		StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("matchtype","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("offset","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*�� ������ ��� ��*/
		urlBuilder.append("&" + URLEncoder.encode("limit","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*�����ڵ�*/
		urlBuilder.append("&" + URLEncoder.encode("orderby","UTF-8") + "=" + URLEncoder.encode("desc", "UTF-8")); /*����*/
		
		URL url = new URL(urlBuilder.toString());
		System.out.println(url.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", apiKey);
		
		return ApiUtil.connToString(conn);
	}
	
public String getMatch(String matchId) throws IOException {
		
		String apiUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/matches/" + matchId;
		
		StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("matchid","UTF-8") + "=" + URLEncoder.encode(matchId, "UTF-8"));
		//urlBuilder.append("/" + URLEncoder.encode(matchId, "UTF-8"));
		
		URL url = new URL(urlBuilder.toString());
		System.out.println(url.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", apiKey);
		
		BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        //JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
        //String jsonPrettyPrintString = xmlJSONObj.toString(StringUtil.INDENT_FACTOR);
        
		return sb.toString();
	}

}
