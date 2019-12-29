package com.it.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
	volatile int number = 0;
	public void addT60(){
		this.number = 60;
	}
	//注意：此时number之前加了volatile关键字修饰的，volatile不保证原子性
	public void addPlusPlus(){
		number++;
	}

	AtomicInteger atomicInteger = new AtomicInteger();
	public void addMyAtomic(){
		atomicInteger.getAndIncrement();
	}
}
/* 1 ，验证volatile的可见性
    1.1 int number=0；number之前不加volatile关键字
    1.2 加volatile关键字之后，可以保证可见性

*  2, volatile 不保证原子性的案例演示：
			why?  多个线程高速调度执行++操作时，从各自的工作内存写回主内存时出现写覆盖现象而导致数据丢失

			如何解决原子性：
			  1）加synchronized关键字（太重了，一般不使用）
			  2）使用juc包里的AtomicInteger
* */
public class VolatileDemo {
	public static void main(String[] args) {
		MyData myData = new MyData();//资源类

		for (int i=1;i<=20;i++){
			new Thread(()->{
				for (int j = 1; j <=1000; j++) {
					myData.addPlusPlus();
					myData.addMyAtomic();
				}
			},String.valueOf(i)).start();
		}
		//等待上面20个线程计算完成后，用mian线程获取计算结果是多少
		while (Thread.activeCount()>2){  //程序只剩主线程和回收线程时，说明计算完了
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"\t int type number value: "+myData.number);
		System.out.println(Thread.currentThread().getName()+"\t atomicInteger type number value: "+myData.number);
	}



	//在共享资源变量前，加volatile关键字，可以及时通知其他线程共享资源的变化
	public static void seeokVolatile(){
		MyData myData = new MyData();//资源类

		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t come in");
			try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace(); }
			myData.addT60();
			System.out.println(Thread.currentThread().getName()+"\t updated data value:"+myData.number);
		},"AAA").start();

		while (myData.number==0){

		}
		System.out.println(Thread.currentThread().getName()+"\t mission is over"+myData.number);
	}

}
