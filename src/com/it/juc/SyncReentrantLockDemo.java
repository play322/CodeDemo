package com.it.juc;
/*
* 	题目：
* 		多线程之间实现顺序调用,实现A->B->C三个线程启动,要求如下：
* 		AA打印5次，BB打印10次，CC打印15次
* 			紧接着
*			AA打印5次，BB打印10次，CC打印15次
* 		。。。
* 		来10轮
* */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncReentrantLockDemo {
	public static void main(String[] args) {
		ShareSource shareSource = new ShareSource();

		new Thread(()->{
			for (int i = 1; i <=10 ; i++) {
				shareSource.print_A();
			}
		},"A").start();

		new Thread(()->{
			for (int i = 1; i <=10 ; i++) {
				shareSource.print_B();
			}
		},"B").start();

		new Thread(()->{
			for (int i = 1; i <=10 ; i++) {
				shareSource.print_C();
			}
		},"C").start();


	}

}
class ShareSource{
	private int num=1; //1:A,2:B,3:C
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();

	public void print_A(){
		lock.lock();
		try {
			//判断
			while (num!=1) {
				//不打印A，等待
				c1.await();
			}
				//干活
				for (int i = 1; i <= 5; i++) {
					System.out.println(Thread.currentThread().getName()+"\t"+i);
				}
			//通知
			num=2;
			c2.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void print_B(){
		lock.lock();
		try {
			//判断
			while (num!=2) {
				//不打印B，等待
				c2.await();
			}
				//干活
				for (int i = 1; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName()+"\t"+i);
				}
			//通知
			num=3;
			c3.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void print_C() {
		lock.lock();
		try {
			//判断
			while (num != 3) {
				//不打印C，等待
					c3.await();
				}
				//干活
				for (int i = 1; i <= 15; i++) {
					System.out.println(Thread.currentThread().getName() + "\t" + i);
				}
			//通知
			num = 1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	}