package com.it.suanfa;

public class Apple1
{
	public int cop(int a,char b){
		return a-b;
	}
	public static void main(String[] args)
	{
		Apple1 a= new De();
		System.out.println(a.cop('A','B'));

	}
}

class De extends Apple1{
	public int cop(int a,int b){
		return b-a;
	}
}
