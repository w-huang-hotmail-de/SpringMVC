package com.coderanch.java;

import java.util.function.Predicate;

public class MainClass {
	public static void main(String[] args) {
		Employee emp = new Employee(null,null);
		System.out.println(emp);
//		System.out.println(getPredicateResult((String str) -> str.length()>10));
//		System.out.println(getPredicateResultAnd(i -> i>=0));
//		System.out.println("Hallo?");
	}
	
	public static boolean getPredicateResult(Predicate<String> p) {
		Predicate<String> t = p.negate();
		return t.test("hello");
	}
	
	public static boolean getPredicateResultAnd(Predicate<Integer> p) {
		Predicate<Integer> p1 = p.and((Number x) -> !x.equals(0));
		Predicate<Integer> p2 = Predicate.isEqual(100);
		boolean b = p1.test(0);
		boolean b1 = p1.test(1);
		boolean b2 = p2.test(10);
		System.out.println("b: " + b);
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		return b1;
	}

}
