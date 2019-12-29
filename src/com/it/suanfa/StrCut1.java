package com.it.suanfa;

import java.util.Scanner;

public class StrCut1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.println(getCut1(s1));
		System.out.println(getCut1(s2));
	}

	private static String getCut(String s) {
		StringBuilder sb = new StringBuilder(s);
		while (sb.length()>=8){
			System.out.println(s.substring(0,8).toString());
			sb.delete(0,8);
		}

		int len = 8-sb.length();
		for (int i=0;i<len;i++){
			sb.append("0");
		}
		return sb.toString();
	}

	private static String getCut1(String s) {

		String sb = new String(s);
		if (sb.length()%8!=0){
			sb = sb+"00000000";
		}

		while (sb.length()>=8){
			System.out.println(sb.substring(0,8).toString());
			sb = sb.substring(8);
		}
		return sb;
	}
}
