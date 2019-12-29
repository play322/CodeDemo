package com.it.suanfa;

import java.util.Scanner;

public class Apple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(F(m,n));
		}
	}

	private static int F(int m, int n) {
		if (m==0 || n==1) {
			return 1;
		}else if (m<n){
			return F(m,m);
		}else{
			return F(m,m-1)+F(m-n,n);
		}
	}
}
