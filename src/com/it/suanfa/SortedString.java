package com.it.suanfa;

import java.io.IOException;
import java.util.Scanner;

/*编写一个程序，将输入字符串中的字符按如下规则排序
规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
       如，输入： Type   输出： epTy
规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     如，输入： BabA   输出： aABb
规则 3 ：非英文字母的其它字符保持原来的位置。
     如，输入： By?e   输出： Be?y*/
public class SortedString {
	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss;
		while ((ss=br.readLine())!=null){

			StringBuilder sb = new StringBuilder();
			for (int i=0;i<26;i++){
				char c = (char)(i+'A');
				for (int j=0;j<ss.length();j++){
					char sc = ss.charAt(j);
					if (c==sc || c==sc-32){
						sb.append(sc);
					}
				}
			}
			for (int i=0;i<ss.length();i++){
				char sc = ss.charAt(i);
				if (!(sc>='a' && sc<='z') && !(sc>='A' && sc<='Z')){
					sb.insert(i,sc);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
*/
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String ss = in.nextLine();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<26;i++){
				char c = (char)(i+'A');
				for(int j=0;j<ss.length();j++){
					char sc = ss.charAt(j);
					if(c==sc || c==sc-32){
						sb.append(sc);
					}
				}
			}
			for(int j=0;j<ss.length();j++) {
				char sc = ss.charAt(j);
				if (!(sc >= 'a' && sc <= 'z') && !(sc >= 'A' && sc <= 'Z')) {
					sb.insert(j, sc);
				}
			}
			System.out.println(sb.toString());

		}
	}
}