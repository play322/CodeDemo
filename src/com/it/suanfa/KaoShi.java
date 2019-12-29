package com.it.suanfa;

import java.util.Scanner;

/*
   This is a Sample
*  sAMPLE A IS tHIS
* */
public class KaoShi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String [] ss = s.split(",");
		String s1 = ss[0];
		String s2 = ss[1];
		int a = Integer.parseInt(s2);
		//int a = sc.nextInt();
		System.out.println(trans(s1,a));
	}

	private static String trans(String s, int a) {
		StringBuilder sb = new StringBuilder();
		//把输入的字符串直接
		char ss[] = s.toCharArray();
		//如果字符串长度不等于输入的整数，直接返回null
		if (s.length()==a) {
			for (int i =0; i < ss.length; i++) {
				if (ss[i]>='a' && ss[i]<='z'){
					char temp1=Character.toUpperCase(ss[i]);
					sb.append(temp1);
				}else if (ss[i]>='A' && ss[i]<='Z'){
					char temp2=Character.toLowerCase(ss[i]);
					sb.append(temp2);
				}else if (ss[i]==' '){
					sb.append(" ");
				}
			}
			String s1 = new String(sb);
			StringBuilder sb1 = new StringBuilder();
			String s2[] = s1.split(" ");
			for (int i=s2.length-1;i>=0;i--){
				sb1.append(s2[i]+" ");
			}
			return sb1.toString().trim();
		}
		return s;
	}
}
