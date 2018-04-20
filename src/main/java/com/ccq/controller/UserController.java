package com.ccq.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccq.pojo.User;

@Controller
public class UserController {
	
	@RequestMapping(value = "setUser", method = RequestMethod.GET)
	@ResponseBody
	public User setUser(HttpSession session) {
		User user = new User();
		user.setName("ccq");
		user.setPassword("123");
		user.setSessionId(session.getId());
		session.setAttribute("user", user);
		return user;
	}

	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return user;
	}
}
