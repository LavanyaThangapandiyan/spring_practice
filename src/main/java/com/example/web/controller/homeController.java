package com.example.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.UserDao;
import com.example.web.model.User;

@Controller
public class homeController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Autowired
	UserDao userdao;
    
    User user=new User();
    
	@RequestMapping("index")
	public String home() 
	{
		return "index.jsp";
	}

	@GetMapping("register")
	public String saveUser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("mobile")String mobile)
     {
		
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		System.out.println(user.getName() +user.getEmail());
		userdao.saveUserDetails(user);
	return "success.jsp";
     }
	@GetMapping("update")
	public String updateUserDetails(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("mobile")String mobile)
	{
		System.out.println("Update..."+name);
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		userdao.updateUserDetails(user);
		return "update.jsp";	
	}
	
	@GetMapping("delete")
	public String deleteUserDetails(@RequestParam("email")String email)
	{
	    System.out.println("Delete..."+email);
	    user.setEmail(email);
	    userdao.deleteUserDetails(user);
		return "index.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
