package com.upupedu.util;

public class StringUtil {
	public static StringBuilder append(StringBuilder sb,String column,String delimit){
		sb.append("\"").append((column==null?"":column)).append("\"").append(delimit);
		return sb;
	}
	public static StringBuilder append(StringBuilder sb,String column){
		return append(sb,column,",");

	}

}
