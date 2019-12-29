package com.it.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortedArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str=br.readLine())!=null) {
			int n = Integer.parseInt(str.split(" ")[0]);
			int k = Integer.parseInt(str.split(" ")[1]);

			String line = br.readLine();
			String[] chArr = line.split(" ");

			int[] intArr = new int[n];
			for (int i = 0; i < intArr.length; i++) {
				intArr[i] = Integer.parseInt(chArr[i]);
			}
			Arrays.sort(intArr);
			for(int i=0;i<k+1;i++){
				if(i==k){
					System.out.print(intArr[i]);
				}else{
					System.out.print(intArr[i]+" ");
				}
			}
		}
		br.close();
	}

}
