package com.it.suanfa;



import java.util.Scanner;



public class TransMoney {

	private static char data[] = new char[]{
			'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
	};
	private static char utils[] = new char[]{
			'元','拾','佰','仟','万','拾','佰','仟','亿'
	};
	private static char dec[] = new char[]{
			'分','角',
	};


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String money = sc.nextLine();
		//int money = sc.nextInt();
		double money = sc.nextDouble();
		System.out.println(converts(money));

	}

	private static String converts(double d) {
		String m = String.valueOf(d);
		if (m.indexOf(".")!=-1){
			String s1 = m.substring(0,m.indexOf("."));
			if (s1.length()>12){
				System.out.println("数字太大，不能完成转换，支持千亿及以下级别的转换");
				return "";
			}
		}else if (m.length()>12){
				System.out.println("数字太大，不能完成转换，支持千亿及以下级别的转换");
			return "";
		}

		String result = getInteger(m)+getDecimal(m);//输出格式为“整数+小数点+小数”
		return result;
	}

	public static String getInteger(String m){
		StringBuilder sb = new StringBuilder();
		if (m.indexOf(".")!=-1){
			String s1 = m.substring(0,m.indexOf("."));
		int count=0;
		int a = Integer.parseInt(s1);
		while (a!=0){
			sb.insert(0,utils[count++]);
			int num = a%10;
			sb.insert(0,data[num]);
			a /=10;
		}
		}
		return sb.toString();
	}

	public static String getDecimal(String m){
		StringBuilder sb = new StringBuilder();
		if (m.indexOf(".")!=-1){
			String s1 = m.substring(m.indexOf(".")+1,m.length());
		int count=0;
		int a = Integer.parseInt(s1);
		while (a!=0){
			sb.insert(0,dec[count++]);
			int num = a%10;
			sb.insert(0,data[num]);
			a /=10;
		}
		}
		return sb.toString();
	}
}
