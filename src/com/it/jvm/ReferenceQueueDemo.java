package com.it.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/*引用队列：ReferenceQueue
* 在GC的时候做一些必要的事情
* */
public class ReferenceQueueDemo {
	public static void main(String[] args) {
		Object o1 = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		WeakReference<Object> weak = new WeakReference<>(o1,referenceQueue);
		System.out.println(o1);
		System.out.println(weak.get());
		System.out.println(referenceQueue.poll());

		System.out.println("============GC之后=====================");
		o1 = null;
		System.gc();
		System.out.println(o1);
		System.out.println(weak.get());
		System.out.println(referenceQueue.poll());
	}
}
