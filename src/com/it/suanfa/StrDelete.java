package com.it.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StrDelete {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = null;
		while((word = br.readLine()) != null) {
			//创建一个Map存储，存储字符串中的字符和其出现的次数
			Map<Character, Integer> map = new LinkedHashMap<>();
			//把输入的字符串转化为字符串数组
			char[] arr = word.toCharArray();
			//迭代字符串数组
			for(int i=0; i<arr.length; i++) {
				//如果集合中已经有这个键，则存入时直接将值加1
				if(map.containsKey(arr[i]))
					map.put(arr[i], map.get(arr[i]) + 1);
				else
					map.put(arr[i], 1);
			}
			//取出map集合中的value，存入Collection中
			Collection<Integer> ci = map.values();
			//借助Collections工具类找最值的方法求出出现次数最小值
			int index = Collections.min(ci);
			//定义一个存结果串的字符串对象
			StringBuilder sb = new StringBuilder("");
			//遍历字符串数组并判断，如果字符串数组中的字符在map中出现的次数不是最小值，那就加入sb
			for(char c : arr) {
				if(map.get(c) != index)
					sb.append(c);
			}
			System.out.println(sb);
		}
	}

}