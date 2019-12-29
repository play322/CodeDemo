package com.it.suanfa;

import java.util.ArrayList;

public class KeyStart {

	public static void main(String[] args) {
		System.out.println("args = [" + args + "]");
		System.out.println("KeyStart.main");

		int a = 0;
		System.out.println("a = " + a);

		String []ss = {"a","c","v","u","p"};
		for (String s : ss) {
			System.out.println(s);
		}
		for (int i = 0; i < ss.length; i++) {
			String s = ss[i];
		}

		ArrayList list = new ArrayList();
		list.add(12);
		list.add(23);
		list.add(43);
	}

	public void method(){

	}
}
