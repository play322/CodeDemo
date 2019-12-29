package com.it.suanfa;

import java.util.Scanner;

/*
输入一个数分成几个数的和
		如输入4再输入2
		4=1+3；
		4=2+2；
*/
public class FenJie {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字“：");
		int x = sc.nextInt();
		System.out.println("请输入位数“：");
		int y = sc.nextInt();

		for(int i = 1; i < x;i++){
			for(int j = 1; j < x;j++){
				if (x==i+j){
					System.out.println(x+"="+i+"+"+j);
				}
			}
		}

	}

}
