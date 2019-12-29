package com.it.suanfa;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** 
* @author 作者 lxl  E-mail: 18421822632@qq.com
* @version 创建时间：2019年9月24日 下午3:17:01 
* 类说明 
*/

/**
 * @author Administrator
 *
 */
public class test1 {
	static List<Integer> resultList=new ArrayList<Integer>();
	static Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
	static boolean flag=false;
	static int count=0;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean flag=false;
		int mun=-1;
		int size=1;
		do {
			
			try {
				System.out.println("请输入分数数字");
				flag=false;
				mun=Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("请输入正常的数字！");
				flag=true;
				
			}
		} while (flag);	
		do {
			
			try {
				System.out.println("请输入分数的个数！");
				flag=false;
				size=Integer.parseInt(scanner.nextLine());
				if(size>mun)
					throw  new Exception();
			} catch (Exception e) {
				System.out.println("数字超过要分的数字或者数字格式不正确请重新输入");
				flag=true;
				
			}
		} while (flag);	
		scanner.close();
		

		count=size;
		resolve(1,mun, size);
		int pre=-1;
		int a=0;
		List<Integer> list=new ArrayList<>();
		int presize=0;
		flag=true;
		for (int i = 0; i < resultList.size()&&flag; i++) {
			switch (resultList.get(i)) {
			case -1:
			{
				System.out.println();
				System.out.print("结果为:mun=");
				list.clear();
				a=0;
				if(i+1>=resultList.size()||resultList.get(i+1)==-1)
					flag=false;
			}
				break;
			case 0:
				{
					a++;
					if(a!=1)
					{
						
						int k=i-pre-1;
						if(presize!=0&&presize<=k)
						{
							int curr=k;
							while(curr-->0) {
								list.remove(size-1-curr);
								list.add(size-1-curr, resultList.get(i-1-curr));
							}
						}
						presize=k;
						for(int j=0;j<size-k;j++)
						{
							
								System.out.print("+"+list.get(j));
						}
						
					}	
					if(a==1)
					{
						int ssize=size;
						while (ssize-->0) {
							list.add(resultList.get(i-size));
						}
						
					}
					pre=i;
					
					if(i+1<resultList.size()&&resultList.get(i+1)!=-1)
					{
						System.out.println();
						System.out.print("结果为:mun=");
					}
				}
				break;

			default:
				if(resultList.get(i+1)==0)
					System.out.print(resultList.get(i));
				else {
					System.out.print(resultList.get(i)+"+");
				}
				break;
			}
			
		}
		System.out.println("结束");
		
	}
	public static void resolve(int min,int max,int size) {
		
			
		for(int i=min;i<=(min+max)/2;i++)//实际应该是max/size不是(min+max)/2存储应该采用树结构读取遍历树结构更佳
		{
			if(size==count)
				resultList.add(-1);
			if(size==1)
			{
				resultList.add(max);
				resultList.add(0);
				break;
			}
			else if(i*size<=max){
				
				resultList.add(i);
				resolve(i, max-i, size-1);
			}
			
		}
		
	}

}
