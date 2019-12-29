package com.it.suanfa;

import java.util.Scanner;

public class StrFirst {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			boolean flag = true;
			String str = sc.nextLine();
			for(int i=0;i<str.length();i++){
				int begin = str.indexOf(str.charAt(i));
				int end = str.lastIndexOf(str.charAt(i));
				if(begin==end){
					System.out.println(str.charAt(i));
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println("-1");
			}
		}
	}
}
