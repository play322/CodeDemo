package com.it.juc;

import java.util.concurrent.TimeUnit;

/*手写死锁*/
class shareResource implements Runnable
{
	private String lockA;
	private String lockB;

	public shareResource(String lockA, String lockB) {
		this.lockA = lockA;
		this.lockB = lockB;
	}

	@Override
	public void run() {
		synchronized (lockA){
			System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockA+"\t尝试获取:"+lockB);

			try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

			synchronized (lockB){
			System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockB+"\t尝试获取:"+lockA);
			}
		}
	}
}
public class DeadLockDemo
{
	public static void main(String[] args)
	{
		String lockA = "lockA";
		String lockB = "lockB";

		new Thread(new shareResource(lockA,lockB),"AAA").start();
		new Thread(new shareResource(lockB,lockA),"BBB").start();

	}
}
