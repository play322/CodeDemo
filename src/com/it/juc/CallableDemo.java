package com.it.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class myThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"\t******Callable<>  come in *******");
		return 1024;
	}
}
public class CallableDemo
{
	public static void main(String[] args) throws Exception
	{
		FutureTask<Integer> futureTask = new FutureTask<>(new myThread());

		Thread t1 = new Thread(futureTask,"AA");
		t1.start();

		System.out.println(futureTask.get());
	}
}
