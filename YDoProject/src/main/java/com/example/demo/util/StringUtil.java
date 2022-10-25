package com.example.demo.util;

import org.apache.logging.log4j.util.Strings;

public class StringUtil {

	public static int INDENT_FACTOR = 4;
	
	public static boolean isNull(Object object) {
		
		if (object == null) return true;
		if (Strings.isBlank(object.toString())) return true;
		if (Strings.isEmpty(object.toString())) return true;
		return false;
	}
	
	public static boolean isEqual(Object object1, Object object2) {
		
		if (object1 == null || object2 == null) return false;
		if (Strings.isBlank(object1.toString()) || Strings.isBlank(object2.toString())) return false;
		if (Strings.isEmpty(object1.toString()) || Strings.isEmpty(object2.toString())) return false;
		
		return object1.equals(object2);
	}
}
