package com.it.jvm;

public class StrongReferenDemo
{
	public static void main(String[] args) {
		Object obj1 = new Object();  //这样定义的就是强引用
		Object obj2 =obj1;
		obj1 =null;
		System.gc();
		System.out.println(obj2);
	}
}
