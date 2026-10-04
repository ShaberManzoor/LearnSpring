package com.learn_springboot.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class FilteringController {

//	STATIC FILTERING START
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value4", "value5", "value6"));
	}
	
//	STATIC FILTERING END
	
	
//	DYNAMIC FILTERING START
	
	@GetMapping("/filtering-with-view") // want field 1 & 3
	@JsonView(View.View1.class)
	public SomeBean filteringWithView() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-list-with-view") //want field 2 & 3
	@JsonView(View.View2.class)
	public List<SomeBean> filteringListWithView() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value4", "value5", "value6"));
	}
	
//	DYNAMIC FILTERING END
	
}
