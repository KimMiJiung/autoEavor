package com.sbproject.autoEavor.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> 42b5e4db57e36675e63c47173d5942cc7447a0ff
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
<<<<<<< HEAD
@RequestMapping(value= {"/main", "/"})
public class MainController {

	@GetMapping("")
	public String main() {
		return "main/main";
	}
	
=======
@RequestMapping(value={"/", "/main"})
public class MainController {
	
	@RequestMapping("")
	public String main() {
		return "/main/main";
	}
	
	
>>>>>>> 42b5e4db57e36675e63c47173d5942cc7447a0ff
}
