package com.it.juf;

import java.util.Arrays;
import java.util.List;

class User
{
	private int id;
	private  String userName;
	private int  age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(int id, String userName, int age) {
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}
}
/*
*  题目：
*    同时满足以下要求：
*
* 		偶数id且年龄大于24且名字转大写且按名字倒排序
* 		只输出一个用户
* */
public class StreamDemo {
	public static void main(String[] args) {
		User u1 = new User(11,"a",20);
		User u2 = new User(13,"b",23);
		User u3 = new User(12,"c",22);
		User u4 = new User(21,"d",29);
		User u5 = new User(16,"e",31);
		User u6 = new User(18,"f",43);

		List<User> list = Arrays.asList(u1,u2,u3,u4,u5,u6);

		list.stream().
				filter(u->{ return u.getId() % 2 ==0;}) //偶数id，  filter：过滤
				.filter(t ->{return t.getAge() >24;})  //年龄大于24，  filter：过滤
				.map(m ->{return m.getUserName().toUpperCase();}) //名字转大写,map:映射
				.sorted((o1,o2)->{return o2.compareTo(o1);})  //名字倒排序，sorted：排序
				.limit(1)  //输出1个名字
				.forEach(System.out::println);



	}
}
