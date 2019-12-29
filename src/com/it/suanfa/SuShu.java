package com.it.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuShu {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = "";
			while((str=br.readLine())!=null){
				int n = Integer.valueOf(str);
				int min = n;
				int a = 0,b = 0;
				for(int i=2;i<=n/2;i++){
					if(!isSuShu(i) || !isSuShu(n-i)) continue;
					int temp = Math.abs(n-i-i);
					if(temp<min){
						min = temp;
						a = i;
						b = n-i;
					}
				}
				System.out.println(a+" "+b);
			}
			br.close();
		}
		public static boolean isSuShu(int n){
			for(int i=2;i*i<=n;i++){
				if(n%i==0)
					return false;
			}
			return true;
		}
	}
