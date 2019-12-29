package com.it.suanfa;

import java.util.Scanner;

public class ShuLie {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		while (sc.hasNext()){
			int a = sc.nextInt();
			System.out.println(getSum(a));
		}
	}

	private static int getSum(int a) {
		if (a==1) return 2;
		return a*2+a*(a-1)*3/2;
	}
}
