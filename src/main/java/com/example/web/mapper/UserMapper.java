package com.example.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.web.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user=new User();
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String email=rs.getString("email");
		user.setName(name);
		user.setEmail(email);
		System.out.println(id+name+email);
		return user;
	}

}
