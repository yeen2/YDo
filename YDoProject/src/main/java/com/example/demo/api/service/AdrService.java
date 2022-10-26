package com.example.demo.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

@Service
public class AdrService {

	private String apiUrl= "http://apis.data.go.kr/1741000/StanReginCd/getStanReginCdList";
	private String serviceKeyEnc = "%2B759QZ2AvTPsX%2B9RcBuuNxca2OgOJFAEFgYyG5ejYCyJGl1GI7TntZjtv6CgQ9nhU%2FdmXYsUoHTFEYZLZEp9mw%3D%3D";
	private String serviceKeyDec = "+759QZ2AvTPsX+9RcBuuNxca2OgOJFAEFgYyG5ejYCyJGl1GI7TntZjtv6CgQ9nhU/dmXYsUoHTFEYZLZEp9mw==";
	
	public static int INDENT_FACTOR = 4;
	
	public String testAdr() throws IOException {
		
        StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKeyEnc); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*호출문서(xml, json) default : xml*/
        urlBuilder.append("&" + URLEncoder.encode("locatadd_nm","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*지역주소명*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code(법정동): " + conn.getResponseCode());
        
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
        System.out.println(sb.toString());
        
        //return "";
        JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
        String jsonPrettyPrintString = xmlJSONObj.toString(INDENT_FACTOR);
        //System.out.println(jsonPrettyPrintString);
        
        return jsonPrettyPrintString;
    }
	
	
}
