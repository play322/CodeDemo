package com.it.suanfa;

import java.util.Scanner;

public class SimplePassword {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    while(sc.hasNext()){
		String str = sc.nextLine();
		String s = "";
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='0' && c<='9'){
				s = s +c;
			}else if(c>='a' && c<='z'){
				if(c>='a' && c<='c'){
					s = s+"2";
				}
				if(c>='d' && c<='f'){
					s = s+"3";
				}
				if(c>='g' && c<='i'){
					s = s+"4";
				}
				if(c>='j' && c<='l'){
					s = s+"5";
				}
				if(c>='m' && c<='o'){
					s = s+"6";
				}
				if(c>='p' && c<='s'){
					s = s+"7";
				}
				if(c>='t' && c<='v'){
					s = s+"8";
				}
				if(c>='w' && c<='z'){
					s = s+"9";
				}
			}else if(c>='A' && c<='Z'){
				char cc = Character.toLowerCase(c);
				if(cc=='z'){
					s = s+"a";
				}else{
					s = s+(char)(Integer.valueOf(cc)+1);
				}
			}
		}
		System.out.println(s);
	}
}
}
