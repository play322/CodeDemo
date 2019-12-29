package com.it.suanfa;

import java.util.Scanner;

public class CardSorted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] s = str.split(" +");
		for(int i=s.length-1;i>=0;i--){
			if(s[i].length()<=20){
				System.out.print(s[i]+" ");
			}
		}
	}
}
