package com.it.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
		//原子引用类
		static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
		//时间戳原子引用类
		static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);
	public static void main(String[] args) {
		System.out.println("==========以下是ABA问题的产生=============");
		new Thread(()->{
			atomicReference.compareAndSet(100,101);
			atomicReference.compareAndSet(101,100);
		},"t1").start();

		new Thread(()->{
			//线程t2暂停1秒,确保上面t1线程完成ABA
			try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());
		},"t2").start();

	//暂停2秒,确保上面t1，t2线程执行完成
		try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println("==========以下是ABA问题的解决=============");

		new Thread(()->{
			//获取版本号
			int result = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+result);
			//线程t3暂停1秒,确保上面t4线程获取版本号
		try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t 第二次版本号："+atomicStampedReference.getStamp());
			atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t 第三次版本号："+atomicStampedReference.getStamp());
		},"t3").start();

		new Thread(()->{
			//获取版本号
			int result = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+result);
			//线程t4暂停3秒,确保t3线程完成ABA操作
			try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace();}
			boolean b = atomicStampedReference.compareAndSet(100, 2019, result, atomicStampedReference.getStamp() + 1);
			System.out.println(Thread.currentThread().getName()+"\t 当前实际版本号："+atomicStampedReference.getStamp());
			System.out.println("修改成功否："+b+"\t当前实际值："+atomicStampedReference.getReference());
			},"t4").start();

	}
}
