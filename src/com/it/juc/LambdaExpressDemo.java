package com.it.juc;

@FunctionalInterface //函数式接口  注解
interface Foo{
	//public void sayHello();
	public  int add(int a,int b);
	default int mul(int a,int b){
		return a*b;
	}

	static int div(int a,int b){
		return a/b;
	}

}

public class LambdaExpressDemo {
	public static void main(String[] args) {

		//Foo foo = ()->{System.out.println("Hello,LambdaExpress");};
		//foo.sayHello();
		Foo foo = (int a,int b)->{return a+b;};
		System.out.println(foo.add(3, 5));
		System.out.println(foo.mul(3, 4));
		System.out.println(Foo.div(12, 3));

	}
}
