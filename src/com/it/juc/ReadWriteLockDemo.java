package com.it.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
*  读写锁：
* 	多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读写同一个资源类应该可以同时进行
*   但是
		当一个线程想去写共享资源时，就不应该有其他线程去对该资源进行读或写

	小总结：
		读-读可以共存
		读-写不能共存
		写-写不能共存
		*
		写操作：原子+独占 ：整个过程必须是一个完整的统一体，不能被分割，被打断
* * */
class MyCache{  //资源类

	private volatile Map<String,Object> map = new HashMap<>();
	//读写锁
	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

	public void put(String key,Object value){
		//从ReentrantReadWriteLock拆分出来的写锁
		rwlock.writeLock().lock();
		try {
		System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
		try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
		map.put(key,value);
		System.out.println(Thread.currentThread().getName()+"\t 正在完成");
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			rwlock.writeLock().unlock();
		}
	}

	public void get(String key){
		rwlock.readLock().lock();
		try {
		System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
		try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
		Object result = map.get(key);
		System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			rwlock.readLock().unlock();
		}
	}
}
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		//5个线程写入操作
		for (int i = 1; i <= 5; i++) {
			final int temp = i;
			new Thread(()->{
				myCache.put(temp+"",temp+"");
			},String.valueOf(i)).start();
		}

		//try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

		//5个线程读操作
		for (int i = 1; i <= 5; i++) {
			final int temp = i;
			new Thread(()->{
				myCache.get(temp+"");
			},String.valueOf(i)).start();
		}
	}
}
