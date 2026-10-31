package com.in28mins.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	public int[] retrieveData() {
		return new int[] {1, 2, 3};
	}
}
