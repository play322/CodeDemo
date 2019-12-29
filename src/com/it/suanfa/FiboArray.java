package com.it.suanfa;

import java.util.TreeSet;

/*
			斐波那契数列：
			找出小于1000数列，
			如1,1,2,3,5,8,13,21
*/
public class FiboArray {

	public static void main(String[] args) {

	/*	int a[] = new int[100];
		getfibo1(a);

		for(int i=1;i<50;i++){
			int fibo = getFibo2(i);
			if (fibo>1000){
				break;
			}
			System.out.print(fibo+" ");
		}
*/
		getArr();

	}

	//数组方式：
		public static void getfibo1(int a[]){
			a[0] = 1;	a[1] = 1;
			System.out.print(a[0]+","+a[1]);
			for (int i = 2;i < a.length;i++) {
				a[i] = a[i-1]+a[i-2];
				if (a[i]>1000){
					break;
				}
				System.out.print(","+a[i]);
			}
		}
	// 递归思想
		public static int getFibo2(int a){
				if (a==1){
					return 1;
				}
				if (a==2){
				return 1;
			}
				return getFibo2(a-1)+getFibo2(a-2);
		}

		public static void getArr(){
		/*
			 两个有序数列进行并集并且将数据为有序，算法复杂度为o(n+m)
			 如：a[1,3,5,9,10,16],b[2,3,5,8,11,15,19]
				C[1,2,3,5,8,9,10,11,15,16,19]
		*/

			int a[] = {1,3,5,9,10,16};
			int b[] = {2,3,5,8,11,15,19};

			TreeSet<Integer> set = new TreeSet<>();
			for (int i=0;i<a.length;i++){
					set.add(a[i]);
			}
			for (int i=0;i<b.length;i++){
				set.add(b[i]);
			}

			System.out.println(set);




		}


}
