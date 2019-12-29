package com.it.suanfa;

import java.util.Scanner;

public class CountChar {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			String str = sc.nextLine().toLowerCase();
			int eng = 0, kong = 0,reg=0,other=0;

			for(int i=0;i<str.length();i++){
				if(str.charAt(i)>='a' && str.charAt(i)<='z'){
					eng++;
					continue;
				}else if(str.charAt(i)==' '){
					kong++;
					continue;
				}else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
					reg++;
					continue;
				}else{
					other++;
				}
			}
			System.out.println(eng);
			System.out.println(kong);
			System.out.println(reg);
			System.out.println(other);

		}

	}
}
