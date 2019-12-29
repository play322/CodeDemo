package com.it.jvm;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

	public static void SoftReference_enough(){
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		o1 = null;
		System.gc();
		System.out.println();
		System.out.println(o1);
		System.out.println(softReference.get());
	}

	/**
	 * 故意配置小内存，产生大对象，让他内存不够用，产生OOM,看软引用是否会被回收
	 * -Xms5m -Xmx5m -XX:+PrintGCDetails
	 * */
	public static void SoftReference_notEnough(){
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		o1 = null;
		try{
			byte[] bytes = new byte[30*1024*1024];
		}catch(Exception e){
		    e.printStackTrace();
		}finally{
			System.out.println(o1);
			System.out.println(softReference.get());
		}
	}
	public static void main(String[] args) {
		//SoftReference_enough();
		SoftReference_notEnough();
	}
}
