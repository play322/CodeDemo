package com.it.mianshi;

import java.util.HashSet;
import java.util.Set;
/*我们玩一个随机0-9组成一个8位不重复数字的字符串.产生4个这样的字符串, 也是互相不重复的*/
public class StrDemo {
	public static void main(String[] args) {
		Set<Integer> s1 =new HashSet<>();
		Set<String> s2 =new HashSet<>();

		while (true){
			s1.clear();
			while (true){
				int a = (int) Math.round(Math.random()*9);
				s1.add(a);
				if (s1.size()==8){
					for (int i: s1) {
						System.out.print(i);
					}
					String s = s1.toString();
					s2.add(s);
					break;
				}
			}
			System.out.println();
			if (s2.size()==4){
				break;
			}
		}
//		for (String s :s2){
//			System.out.println(s);
//		}
	}
}
