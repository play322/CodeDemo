package com.it.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*生产者与消费者模式*/
class shareData{
	private volatile boolean FLAG = true;  //默认开启生产者与消费者
	private AtomicInteger atomicInteger = new AtomicInteger();
	private BlockingQueue<String> blockingQueue = null;

	public shareData(BlockingQueue<String> blockingQueue) {//构造传接口可以适配所有子实现类，扩展性好
		this.blockingQueue = blockingQueue;
		System.out.println("传入的是"+blockingQueue.getClass().getName()); //通过反射查看传入干活的是哪个阻塞队列的子类
	}

	public void myProd() throws Exception{
		String data=null;
		boolean result;
		while (FLAG){
			data = atomicInteger.incrementAndGet()+"";
		  result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
		  if (result){
				System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"成功");
			}else {
				System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"失败");
			}
			try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		System.out.println(Thread.currentThread().getName()+"\t叫停了，FLAG=false，停止生产动作");
	}

	public void myConsumer() throws Exception{
		String result =null;
		while (FLAG){
			 result = blockingQueue.poll(2L, TimeUnit.SECONDS);
			 if (result==null || "".equalsIgnoreCase(result)){ //从队列取不到数据，或取到的为空
						FLAG = false;
				 System.out.println(Thread.currentThread().getName()+"\t超过2秒，没有取到数据，消费结束");
				 System.out.println();
				 System.out.println();
				 return; //一定要写，不然会一直等待
			 }
			System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
		}
	}

	public void stop() throws  Exception{
		this.FLAG = false;
	}
}
public class Pro_Consumer_BlockingQueueDemo
{
	public static void main(String[] args)
	{
		shareData shareData = new shareData(new ArrayBlockingQueue<>(3));

		new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
				shareData.myProd();
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"Prod").start();

		new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
				shareData.myConsumer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"Consumer").start();

		//5秒钟后停止生产消费
		try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println();
		System.out.println();
		System.out.println(Thread.currentThread().getName()+"\t5秒时间到，叫停活动");

		try {
			shareData.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
