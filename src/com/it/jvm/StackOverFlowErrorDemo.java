package com.it.jvm;
/*栈内存溢出：
		原因：方法递归调用，找不到出口，导致的方法深度调用压爆栈内存
*/
public class StackOverFlowErrorDemo {
	public static void main(String[] args) {
		myStackError();
	}

	private static void myStackError() {
		myStackError();
	}
}
