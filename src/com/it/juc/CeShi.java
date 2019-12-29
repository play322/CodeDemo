package com.it.juc;

public class CeShi {
	public static void main(String[] args){
			Print p = new Print();

			/*打印A的进程*/
		new Thread(()->{
			for (int i = 0; i <10; i++) {
				p.print_a();
				try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			}
		}).start();

			/*启动打印B的线程*/
		new Thread(()->{
			while (true){
				p.print_b();
			}
		}).start();

			/*启动打印C的线程*/
		new Thread(()->{
			while (true){
				p.print_c();
			}
		}).start();
		}
	}

	/**/
	class Print {
		/*flag用来同步*/
	volatile int flag=1;
		/*打印 A */
		public synchronized void print_a(){
			if (flag==1){
			System.out.print("A");
			flag=2;
			this.notifyAll();
			}
		}
		/*打印B*/
		public synchronized void print_b(){
			if (flag==2){
				System.out.print("B");
			flag=3;
			this.notifyAll();
			}
		}
		/*打印C*/
		public synchronized void print_c(){
			if (flag==3){
				System.out.print("C");
			flag=1;
			this.notifyAll();
			}
		}
	}
