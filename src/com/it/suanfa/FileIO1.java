package com.it.suanfa;

import java.io.File;
import java.io.FilenameFilter;

public class FileIO1 {
	public static void main(String[] args){
		File file = new File("F:\\java学习资料\\SpringBoot\\高级");
		File [] f1 = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".flv")){
					return true;
				}
				return false;
			}
		});

		for (File files:f1){
			String fileName = files.getName();
			String newName = fileName.replace(fileName.substring(4,21),"");
			File file1 = new File(file,newName);
			files.renameTo(file1);


		}

	}

}
