package com.example.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.web.model.User;

public class UserMapper implements  RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user=new User();
		String name=rs.getString("name");
		String email=rs.getString("email");
		String mobile=rs.getString("mobile");
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		System.out.println(name+email+mobile);
		return user;
	}
	
}
