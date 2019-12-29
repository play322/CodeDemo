package com.it.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindSqert {
	public static boolean isTest = false;

	public static void main(String [] args) throws IOException {
		if(isTest) {
			new FindSqert().test();
		} else {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = null;
			do {
				str = br.readLine();
				if(str != null) {
					double d = new FindSqert().run(str);
					String tempD = Double.toString(d);
					tempD = tempD.substring(0, 4);
					int last = Integer.parseInt(tempD.substring(3, 4));
					if(last >= 5) {
						d += 0.1;
					}
					tempD = Double.toString(d);
					tempD = tempD.substring(0, 3);
					System.out.println(tempD);
				}
			} while (str != null);
		}
	}

	public double run(String str) {
		double num = Double.parseDouble(str);
		double dis = 1.0;
		double start = 0.1;
		for(double i=0.1; dis > 0.0; i+=0.01) {
			double temp = i*i*i;
			dis = num-temp;
			start = i;
		}
		return start;
	}

	public void test() {
		String test = "11";
		double d = new FindSqert().run(test);
		String tempD = Double.toString(d);
		tempD = tempD.substring(0, 4);
		int last = Integer.parseInt(tempD.substring(3, 4));
		if(last >= 5) {
			d += 0.1;
		}
		tempD = Double.toString(d);
		tempD = tempD.substring(0, 3);
		System.out.println(tempD);
	}
}
