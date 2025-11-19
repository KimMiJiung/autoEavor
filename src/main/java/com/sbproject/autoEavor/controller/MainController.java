package com.sbproject.autoEavor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value={"/", "/main"})
public class MainController {
	
	@RequestMapping("")
	public String main() {
		return "/main/main";
	}
	
	
}
