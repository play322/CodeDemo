package com.it.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrCut {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string="";
		String str1="";
		String str2="";
		while ((string=br.readLine())!=null){
			String ss [] = string.split(" ");
			str1 = ss[0];
			str2 = ss[1];
			System.out.println(getStr(str1,str2));
		}

	}

	private static String getStr(String str1, String str2) {
		int num = 0;
		int count  = Integer.parseInt(str2);
		StringBuilder sb = new StringBuilder();
		for (int i=0;num<count;i++){
			char c = str1.charAt(i);
			if ((c>='a' && c<='z') || (c>='A' && c<='Z')){
				num++;
			}else{
				if (num==count-1){
					num+=2;
				}else{
					num+=2;
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
