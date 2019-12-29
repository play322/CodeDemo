package com.it.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
* 	ArrayList 集合类线程不安全
* */
public class ListNotSafeDemo {
	public static void main(String[] args) {

		//Map<String,String> map = new HashMap<>();
		//Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
		Map<String,String> map = new ConcurrentHashMap<>();
		for (int i = 1; i <=30; i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
	}

	public static  void setUnSafe(){

		//Set<String> set = new HashSet<>();
		//Set<String> set = Collections.synchronizedSet(new HashSet<>());
		Set<String> set = new CopyOnWriteArraySet<>();
		for (int i = 1; i <=30; i++) {
			new Thread(()->{
				set.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(set);
			},String.valueOf(i)).start();
		}

	}

	public static void arrayListUnSafe(){
		//	List<String> list = new ArrayList<>();
		//	List<String> list = new Vector<>();
		//	List<String> list = Collections.synchronizedList(new ArrayList<>());
		List<String> list = new CopyOnWriteArrayList<>();
		for (int i = 1; i <=30; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start();
		}
		//java.util.ConcurrentModificationException
		/*
		 * 	1,故障现象：
		 * 			java.util.ConcurrentModificationException
		 *
		 *   2，导致原因：
		 *
		 *
		 * 	3，解决方案：
		 *       3.1  使用 new Vector();
		 * 			3.2  Collections.synchronizedList(new ArrayList<>());
		 *       3.3  new CopyOnWriteArrayList<>();
		 *
		 *   4,优化建议：
		 *
		 *
		 *
		 * */
	}
}
