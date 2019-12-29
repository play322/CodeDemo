package com.it.suanfa;
import java.util.Scanner;
public class Kuohao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入字符串：");
		String str = sc.nextLine();
		System.out.println("输入整数：");
		int a = sc.nextInt();
		boolean flag = isTrue(str,a);
		System.out.println(flag);
	}

	private static boolean isTrue(String A, int a) {
		int left = 0;
		int right = 0;
		if (A.length() % 2 == 1) {
			return false;
		} else {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == '(') {
					left++;
				} else if (A.charAt(i) == ')') {
					right++;
				}
			}
			if (left == right) {
				return true;
			}
			return false;
		}
	}
}
