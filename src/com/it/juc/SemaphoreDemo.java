package com.it.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3); //模拟3个车位

		for (int i = 1; i <=6; i++) { //模拟6个车
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"\t抢到车位");
					TimeUnit.SECONDS.sleep(5); //抢到车位后停车5秒离开
					System.out.println(Thread.currentThread().getName()+"\t5秒后离开车位");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release(); //释放车位
				}
			},String.valueOf(i)).start();
		}
	}
}
