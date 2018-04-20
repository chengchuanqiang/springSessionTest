package com.ccq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccq.pojo.User;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	
	@RequestMapping(value = "setUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject setUser(HttpSession session,HttpServletRequest request) {
		User user = new User();
		user.setName("ccq");
		user.setPassword("123");
		user.setSessionId(session.getId());
		session.setAttribute("user", user);
		
		JSONObject json = JSONObject.fromObject(user);
		json.put("serverPort", request.getLocalPort());
		System.out.println(request.getServerPort() + " : " + request.getLocalPort() + " : " + request.getRemotePort() );
		
		return json;
	}

	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getUser(HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		JSONObject json = JSONObject.fromObject(user);
		json.put("serverPort", request.getLocalPort());
		System.out.println(request.getServerPort() + " : " + request.getLocalPort() + " : " + request.getRemotePort() );
		return json;
	}
}
