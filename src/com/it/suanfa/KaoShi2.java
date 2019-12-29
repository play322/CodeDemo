package com.it.suanfa;

import java.util.Scanner;
/*机试写的代码*/
public class KaoShi2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int a = sc.nextInt();
		System.out.println(trans(s,a));
	}

	private static String trans(String s, int a) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		//倒着循环字符串
		for (int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if (c>='a' && c<='z'){
				c = Character.toUpperCase(c);
			}else if (c>='A' && c<='Z'){
				c = Character.toLowerCase(c);
			}
			sb.append(c);
	}
		String str = new String(sb);
		String ss [] = str.split(" ");
		for (int j=ss.length-1;j>=0;j--){
			sb1.append(ss[j]+" ");
		}
		return sb1.toString().trim();
}
}
