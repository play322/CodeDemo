package com.it.suanfa;

import java.util.Scanner;

public class Password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(isTrue(str));
		}
	}
	public static String isTrue(String str){
			int reg = 0;
			int low = 0;
			int up = 0;
			int other = 0;
		if(str.length()<= 8){
			return "NG";
		}

		for (int i = 0;i<str.length()-3;i++){
			if (str.substring(i+3,str.length()).contains(str.substring(i,i+3))){
				return "NG";
			}
		}
			int count[] = new int[4];
		for(int i=0; i<str.length();i++) {
				char c[] = str.toCharArray();
				if (c[i] >= '0' && c[i] <= '9') {
					count[0] =1;
				} else if (c[i] >= 'a' && c[i] <= 'z') {
					count[1] =1;
				} else if (c[i] >= 'A' && c[i] <= 'Z') {
					count[2] =1;
				} else {
					count[3] = 1;
				}
			}
		if (count[0] + count[1] + count[2] + count[3] < 3) {
			return "NG";
		}
		return "OK";
	}
}
