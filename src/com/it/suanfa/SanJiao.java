package com.it.suanfa;

import java.util.Scanner;

public class SanJiao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a==b && b==c && a==c){
			System.out.println("全等三角形");
		}else if (a*a+b*b==c*c ||a*a+c*c==b*b ||b*b+c*c==a*a){
			System.out.println("直角三角形");
		}else if(a==b ||b==c || a==c){
			System.out.println("等腰三角形");
		}else{
			System.out.println("不等三角形");
		}

	}
}
