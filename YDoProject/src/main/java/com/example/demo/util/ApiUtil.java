package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class ApiUtil {
	
	public static int INDENT_FACTOR = 4;

	public static String connToString(HttpURLConnection conn) throws IOException {
		
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
        
        return sb.toString();
        
//        JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
//        String jsonPrettyPrintString = xmlJSONObj.toString(INDENT_FACTOR);
//        
//        return jsonPrettyPrintString;
	}
}
