package com.it.suanfa;
/*
* 	They are students;
* 	auieos;
*
* Thy r tdnt;
* */
import java.util.Scanner;

public class KaoShi3_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String longStr = sc.nextLine();
		String shortStr = sc.nextLine();

		StringBuilder sb = new StringBuilder();

		char cc[] = longStr.toCharArray();
		for (char c: cc){
//			if (shortStr.indexOf(c)==-1){
//				sb.append(c);
//			}
			System.out.print(c);
		}

		System.out.println(sb.toString());
		}

}

