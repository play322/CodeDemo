package com.it.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PicSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> list = new ArrayList<>();
		while (sc.hasNext()){
			String str = sc.nextLine();
			if (str.length()<=1024){
				for (int i=0;i<str.length();i++){
					list.add(str.charAt(i));
				}
			}
		}
		Collections.sort(list);
		for (Character c: list){
			System.out.print(c);
		}
	}
}
