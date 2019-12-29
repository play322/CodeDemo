package com.it.jvm;

public class JvmDemo01
{
	public static void main(String[] args)
	{
		/*long maxMemory = Runtime.getRuntime().maxMemory();  //返回Java虚拟机试图使用的最大内存量
		long totaMemory = Runtime.getRuntime().totalMemory(); //返回Java虚拟机中的内存总量
		System.out.println("-Xmx:MAX_MEMORY="+maxMemory+"(字节)->"+(maxMemory/(double)1024/1024+"MB"));
		System.out.println("-Xms:TOTAL_MEMORY="+totaMemory+"(字节)->"+(totaMemory/(double)1024/1024+"MB"));*/

			/*String s = "hello";
			while (true){
				s += s + new Random().nextInt(88888)+new Random().nextInt(9999999);
			}*/

			byte [] b = new byte[30*1024*1024];
	}
}
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space