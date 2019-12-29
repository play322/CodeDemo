package com.it.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
    生产者消费者模式代码案例：

*  题目：
*    两个线程共同操作一个初始值为零，一个加1，一个减一，来回交替5次
* */
class ShareData{
	private int num = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void increament(){
		lock.lock();
		try {
			//1，判断
			while (num!=0){
				//2，等待，不能加
				condition.await();
			}
			//3,干活
			num++;
			System.out.println(Thread.currentThread().getName()+"\t"+num);
			//4,唤醒
			condition.signalAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}

	}

	public void decreament(){
		lock.lock();
		try {
			//1，判断
			while (num==0){
				//2，等待，不能减
				condition.await();
			}
			//3,干活
			num--;
			System.out.println(Thread.currentThread().getName()+"\t"+num);
			//4,唤醒
			condition.signalAll();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
public class Pro_Consumer_TrandtionalDemo
{
	public static void main(String[] args)
	{
		ShareData shareData = new ShareData();
		//创建2个线程
		new Thread(()->{
			for (int i = 1; i <=5 ; i++) {
				shareData.increament();
			}
		},"AA").start();

		new Thread(()->{
			for (int i = 1; i <=5 ; i++) {
				shareData.decreament();
			}
		},"BB").start();

	}
}
