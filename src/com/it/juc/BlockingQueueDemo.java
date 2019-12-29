package com.it.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo
{
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

		System.out.println(blockingQueue.offer("a", 2l, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2l, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2l, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2l, TimeUnit.SECONDS));

	}
}
