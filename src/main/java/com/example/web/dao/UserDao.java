package com.example.web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.web.model.User;

@Repository
public class UserDao
{
	
@Autowired
JdbcTemplate jdbcTemplate; 
public void saveUserDetails(User user)
{
String insert="insert into user(name,email,mobile)values(?,?,?)";
System.out.println(user.getName());
Object[] details= {user.getName(),user.getEmail(),user.getMobile()};
int numberOfRows=jdbcTemplate.update(insert,details);
System.out.println("Inserted Rows : "+numberOfRows);
System.out.println("Save Details");
}
public int updateUserDetails(User user)
{
	String update="update user set name=?,mobile=? where email=?";
	Object[]details= {user.getName(),user.getMobile(),user.getEmail()};
	int numberOfRows=jdbcTemplate.update(update,details);
	System.out.println("Updated rows : "+numberOfRows);
	return numberOfRows;
	
}
public int deleteUserDetails(User user)
{
	String delete="delete from user where email=? ";
	Object[]details= {user.getEmail()};
	int numberOfRows=jdbcTemplate.update(delete,details);
	System.out.println("Deleted Rows : "+numberOfRows);
	return numberOfRows;	
}

}
