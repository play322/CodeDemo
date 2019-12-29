package com.it.jvm;

import java.lang.ref.WeakReference;
/*弱引用案例
* 不管内存够不够，只要GC就被回收
* */
public class WeakReferenceDemo {
	public static void main(String[] args) {
		Object o1 = new Object();
		WeakReference<Object> weak = new WeakReference<>(o1);
		System.out.println(o1);
		System.out.println(weak.get());
		o1 = null;
		System.gc();
		System.out.println("==========================");
		System.out.println(o1);
		System.out.println(weak.get());
	}
}
