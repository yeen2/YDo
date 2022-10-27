package com.example.demo.api.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.example.demo.util.ApiUtil;

@Service
public class Api001Service {

	private String apiUrl= "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
	private String serviceKeyEnc = "wIF3vZYEhYV6CPAz11BRpDeWVsPvO94Of6oxAoSHdan%2BN1TLNwnMTYvgSDtjUOGxxK6WcN8iDBZCdi7L9YsvAA%3D%3D";
	//private String serviceKeyDec = "wIF3vZYEhYV6CPAz11BRpDeWVsPvO94Of6oxAoSHdan+N1TLNwnMTYvgSDtjUOGxxK6WcN8iDBZCdi7L9YsvAA==";
	
	public String test() throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKeyEnc); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*�����ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202012", "UTF-8")); /*����*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        return ApiUtil.connToString(conn);
	}
}
