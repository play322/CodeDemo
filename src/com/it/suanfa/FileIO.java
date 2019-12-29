package com.it.suanfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

public class FileIO {
	public static void main(String[] args) throws FileNotFoundException {

		//InputStream in = new FileInputStream(new File("F:\\java学习资料\\SpringCloud"));
		File file = new File("F:\\java学习资料\\SpringCloud");

			File [] files = file.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					if (name.endsWith(".flv")){
						return true;
					}
					return false;
				}
			});

			for (File file1:files){
				String s1 = file1.getName();
				String s2 = s1.replace(s1.substring(3,22),"");
				File ft=new File(file,s2);
				//file1.renameTo(ft);
				System.out.println(file1.renameTo(ft));
			}


	}

}
