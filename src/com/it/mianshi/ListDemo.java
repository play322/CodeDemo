package com.it.mianshi;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo
{
	public static void main(String[] args)
	{
		List<Integer> list = new CopyOnWriteArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(9);

		for (Integer i : list)
		{
			if (i%2==0)
			list.remove(i);
		}
		System.out.println(list);
	}
}
