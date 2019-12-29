package com.it.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 1; i <=6 ; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 国被灭");
				countDownLatch.countDown();
			},CountryEnum.forEach(i).getRetMsg()).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t ****************秦国，一统天下");
	}

	public static void closeDoor()throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(6);

		for (int i = 1; i <=6 ; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 离开教室");
				countDownLatch.countDown();
			},String.valueOf(i)).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t 班长锁门离开教室");
	}
}
