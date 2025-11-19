package com.sbproject.autoEavor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/hello") 
	public String hello12() {
		
		return "/hello/hello";
	}
	// http://localhost:8080/hello /hello url과 hello()메서드를 매핑한다
	
	@ResponseBody
	// hello() 메서드의 리턴값이 문자열 그 자체임을 나타낸다.
	public String hello() {
		return "Hello World";
	}
	
	
}
