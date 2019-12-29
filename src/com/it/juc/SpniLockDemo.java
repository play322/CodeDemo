package com.it.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
*   手写一个自旋锁
* */
public class SpniLockDemo {
	//原子引用线程
	static AtomicReference<Thread> atomicReference = new AtomicReference<>();

	public void myLock(){
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t come in ");
		//当期望值不是空的，说明有人在使用锁，那么线程就进死循环里等待，直到期望值为空即锁被释放时，跳出死循环
		while (!atomicReference.compareAndSet(null,thread)){

		}
	}

	public void myUnLock(){
		Thread thread = Thread.currentThread();
		atomicReference.compareAndSet(thread,null);
		System.out.println(Thread.currentThread().getName()+"\t myUnLock() ");
	}

	public static void main(String[] args) {
		SpniLockDemo spniLockDemo = new SpniLockDemo();

		new Thread(()->{
			spniLockDemo.myLock();
			//线程AA持有锁5秒钟后再释放锁
			try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
			spniLockDemo.myUnLock();
			},"AA").start();

		//主线程等待1秒钟，让AA线程先启动
			try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

		new Thread(()->{
			spniLockDemo.myLock();
			//线程BB等待1秒钟后再释放锁
			try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			spniLockDemo.myUnLock();
		},"BB").start();
	}

}
