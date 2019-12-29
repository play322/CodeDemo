package com.it.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements  Runnable{
	public  synchronized  void sendSMS(){
		System.out.println(Thread.currentThread().getName()+"\t sendSMS()");
		sendEmail();
	}

	public  synchronized  void sendEmail(){
		System.out.println(Thread.currentThread().getName()+"\t sendEmail()");
	}

	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		get();
	}

	public void get(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t get()");
			set();
		}finally {
			lock.unlock();
		}
	}

	public void set(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t set()");
		}finally {
			lock.unlock();
		}
	}
}
public class ReenterLock {
	public static void main(String[] args) throws InterruptedException {
		Phone p = new Phone();

		new Thread(()->{
			p.sendSMS();
		},"t1").start();

		new Thread(()->{
			p.sendSMS();
		},"t2").start();

		TimeUnit.SECONDS.sleep(1);
		System.out.println("==============================");

		Thread t3 = new Thread(p,"t3");
		Thread t4 = new Thread(p,"t4");

		t3.start();
		t4.start();
	}

}
