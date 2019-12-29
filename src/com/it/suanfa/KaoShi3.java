package com.it.suanfa;

/*
* 	They are students;
* 	auieos;
*
* Thy r tdnt;
* */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaoShi3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String s1[] = sc.nextLine().split(" ");
		String s1 = sc.nextLine();
	//String s2 = sc.nextLine();
		char s2[] = sc.nextLine().toCharArray();
	//char cc = sc.nextLine().toCharArray()[0];
		List<Character> list = new ArrayList<>();

		for (int i=0;i<s1.length();i++) {
			//System.out.println(s1.charAt(i));
			for (int j = 0; j < s2.length; j++) {
				if (s2[j] != s1.charAt(i)) {
					list.add(s1.charAt(i));
				}
			}
		}
		for(Character c: list){
			System.out.print(c);
		}




	}
}


/*
for (int i=0;i<s1.length();i++){
		//System.out.println(s1.charAt(i));
		for (int j=0;j<s2.length();j++){
		if (s2.charAt(j)!=s1.charAt(i)) {
		list.add(s1.charAt(i));
		}
		}*/
