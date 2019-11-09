package org.wrf.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wrf.aop.service.UserService;

@RestController
public class HelloController {

	//@RequestMapping("/test")
	//@Action
	//public String hello() {
	//	return "Hello Spring Boot";
	//}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam("name") String name) {
		userService.login();
		return "Hello " + name;
	}

}