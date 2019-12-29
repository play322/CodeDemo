package com.it.suanfa;

import java.util.Scanner;

public class StrDiff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入字符串：");
		String s = sc.nextLine();
		System.out.println(isTrue(s));


	}

	public static boolean isTrue(String ss) {

		//char c = ss.charAt(0);
		for (int i = 0; i < ss.length(); i++) {
			//if (!ss.contains(Character.toString(ss.charAt(i)))) {
			//if (c!=ss.charAt(i)){
			for (int j = ss.length()-1; j >=0; j--) {
				if (ss.charAt(i) == ss.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}