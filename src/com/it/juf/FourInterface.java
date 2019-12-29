package com.it.juf;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*四大函数式接口*/
public class FourInterface {
	public static void main(String[] args) {
		//消费性接口
		Consumer<String> consumer = s->{ System.out.println(s); };
		consumer.accept("Consumer Inteface");

		//供给型接口
		Supplier<String> supplier = ()->{return "Supplier Inteface";};
		System.out.println(supplier.get());

		//函数型接口
		Function<String,Integer> function = s ->{return s.length();};
		System.out.println(function.apply("Function Interface"));

		//断定性接口
		Predicate<String> predicate = s -> {return s.isEmpty();};
		System.out.println(predicate.test("java"));
	}
}
