package com.it.juc;

import java.util.concurrent.*;
/*第4种获的多线程的方式：线程池   */
public class MyThreadPoolDemo
{
	public static void main(String[] args)
	{
		ExecutorService threadPool = new  ThreadPoolExecutor(2,
																											5,
																												1L,
																												TimeUnit.SECONDS,
																												new LinkedBlockingQueue<>(3),
																												Executors.defaultThreadFactory(),
																												//new ThreadPoolExecutor.AbortPolicy()); //默认拒绝策略
																												//new ThreadPoolExecutor.CallerRunsPolicy()); //任务回退给调用者
																												//new ThreadPoolExecutor.DiscardOldestPolicy()); //抛弃等待最久的任务
																												new ThreadPoolExecutor.DiscardPolicy()); //丢失任务，不报异常
		try {
			//模拟10个客户来办理业务
			for (int i = 1; i <= 10; i++) {
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+"\t 办理业务*****");
				});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			threadPool.shutdown();
		}
	}

	public static void threadpoolDemo(){
		//模拟银行（threadPool），有5个窗口办理业务
		//ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池固定数线程
		//ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池一线程
		ExecutorService threadPool = Executors.newCachedThreadPool(); //一池N线程

		try {
			//模拟10个客户来办理业务
			for (int i = 1; i <= 10; i++) {
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+"\t 办理业务*****");
				});
				TimeUnit.MILLISECONDS.sleep(200);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			threadPool.shutdown();
		}


	}
}
