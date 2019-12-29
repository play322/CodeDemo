package com.it.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*   30张票，三个售票员卖
* */
class Ticket
{
	private int num = 30;
	Lock lock = new ReentrantLock();

	public void sale()
	{
		lock.lock();
		try {
			if (num>0)
			{
				System.out.println(Thread.currentThread().getName()+"\t卖出第"+(num--)+" 张票，还剩："+num);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
public class SaleTicketDemo
{
	public static void main(String[] args)
	{
		Ticket ticket = new Ticket();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 40; i++) {
				ticket.sale();
				}
			}
		},"A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 40; i++) {
					ticket.sale();
				}
			}
		},"B").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 40; i++) {
					ticket.sale();
				}
			}
		},"C").start();


	}
}
