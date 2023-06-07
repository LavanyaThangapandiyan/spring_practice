package com.example.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.UserDao;
import com.example.web.model.User;

@Controller
public class HomeController {
	
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
		int number=userdao.saveUserDetails(user);
		if(number==1)
		return "success.jsp";
		else
			return "index.jsp";
     }
	@GetMapping("update")
	public String updateUserDetails(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("mobile")String mobile)
	{
		
		System.out.println("Update..."+name);
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		int updateUser= userdao.updateUserDetails(user);
		if(updateUser==1)
			return "index.jsp";
		else
		return "update.jsp";	
	}
	
	@GetMapping("delete")
	public String deleteUserDetails(@RequestParam("email")String email)
	{
	    System.out.println("Delete..."+email);
	    user.setEmail(email);
	    int deleteUser = userdao.deleteUserDetails(user);
	    if(deleteUser==1)
		return "index.jsp";
	    else
	    	return "delete.jsp";
	}
	
	@GetMapping("userlist")
	public String getAllUser(Model model)
	{
		List<User> users=userdao.userList();
		model.addAttribute("userlist",users);
		return "list.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
