package com.it.juc;

import java.util.concurrent.atomic.AtomicInteger;
/*
		CAS:compareAndSwap
		 比较并交换
*
* */
public class CASDemo {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(4);

		// main do something....
		atomicInteger.getAndIncrement();
		System.out.println(atomicInteger.compareAndSet(4, 2019)+"\t current value:"+atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(2019, 1024)+"\t current value:"+atomicInteger.get());
	}
}
