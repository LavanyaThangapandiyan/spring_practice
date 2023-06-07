package com.example.web.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.web.mapper.UserMapper;
import com.example.web.mapper.UserMapperSingle;
import com.example.web.model.User;
import com.example.web.validation.Validation;

@Repository
public class UserDao {
	Validation valid = new Validation();
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int saveUserDetails(User user) 
	{
	    List<User> userList = userList();
		String getUser = userList.toString();
		String userEmail = user.getEmail();
		boolean contains = getUser.contains(userEmail);
		System.out.println(contains);
		if (contains == true) 
		{
			System.out.println(" Email Already Exist");
		}
		else 
		{
			String insert = "insert into user(name,email,mobile)values(?,?,?)";
			System.out.println(user.getName());
			boolean name = valid.nameValidation(user.getName());
			boolean email1 = valid.emailValidation(user.getEmail());
			boolean phone = valid.phoneNumberValidation(user.getMobile());
			if (name == true && email1 == true && phone == true) {
				Object[] details = { user.getName(), user.getEmail(), user.getMobile() };
				int numberOfRows = jdbcTemplate.update(insert, details);
				System.out.println("Inserted Rows : " + numberOfRows);
				return 1;
			} else
				System.out.println("Invalid Data");
		}
		return 0;
	}
	public int updateUserDetails(User user) 
	{
		List<User> userList = userList();
		String getUser = userList.toString();
		String userEmail = user.getEmail();
		boolean contains = getUser.contains(userEmail);
		System.out.println(contains);
		if (contains == true) 
		{
			boolean name = valid.nameValidation(user.getName());
			boolean email = valid.emailValidation(user.getEmail());
			boolean phone = valid.phoneNumberValidation(user.getMobile());
			if (name == true && email == true && phone == true) 
			{
				String update = "update user set name=?,mobile=? where email=?";
				Object[] details = { user.getName(), user.getMobile(), user.getEmail() };
				int numberOfRows = jdbcTemplate.update(update, details);
				System.out.println("Updated rows : " + numberOfRows);
				return 1;
			} else 
				System.out.println("Invalid Data");
		}
		else 
			System.out.println("Invalid Data");
		return 0;
		}
	public int deleteUserDetails(User user) {
		List<User> userList = userList();
		String getUser = userList.toString();
		String userEmail = user.getEmail();
		boolean contains = getUser.contains(userEmail);
		System.out.println(contains);
		if (contains == true) 
		{
			boolean email = valid.emailValidation(user.getEmail());
			if (email == true) {
				String delete = "delete from user where email=? ";
				Object[] details = { user.getEmail() };
				int numberOfRows = jdbcTemplate.update(delete, details);
				System.out.println("Deleted Rows : " + numberOfRows);
				return 1;
			} else
				System.out.println("Invalid");
		}
		else 
			System.out.println("Invalid Email Id");
		
		return 0;
	}

	public List<User> userList() {
		String userList = "select name,email,mobile from user";
		List<User> listUser = jdbcTemplate.query(userList, new UserMapper());
		System.out.println(listUser);
		return listUser;
	}
	
	 public User findByEmail(String email)
     {
   	
     	String find="select name,mobile from user where email=?";
   	    User listUser=jdbcTemplate.queryForObject(find,new UserMapperSingle(),email);
     	System.out.println(listUser);
		return listUser ;
   	  
     }
	

}
