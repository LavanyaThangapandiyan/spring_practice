package com.example.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.web.mapper.UserMapper;
import com.example.web.model.User;
import com.example.web.validation.Validation;

@Repository
public class UserDao {
	Validation valid = new Validation();
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveUserDetails(User user) 
	{
/*List<User> userList = userList();
String email = user.getEmail();
boolean contains = userList.contains(email);
System.out.println(contains);
*/
		String insert="insert into user(name,email,mobile)values(?,?,?)";
        System.out.println(user.getName());
		boolean name=valid.nameValidation(user.getName());
		boolean email=valid.emailValidation(user.getEmail());
		boolean phone=valid.phoneNumberValidation(user.getMobile());
		if(name==true&&email==true&&phone==true)
		{
			Object[] details= {user.getName(),user.getEmail(),user.getMobile()};
			int numberOfRows=jdbcTemplate.update(insert,details);
			System.out.println("Inserted Rows : "+numberOfRows);
		}else
		{
			System.out.println("Invalid Data");
		}
	} 

	public int updateUserDetails(User user) {
		String update = "update user set name=?,mobile=? where email=?";
		Object[] details = { user.getName(), user.getMobile(), user.getEmail() };
		int numberOfRows = jdbcTemplate.update(update, details);
		System.out.println("Updated rows : " + numberOfRows);
		return numberOfRows;
	}

	public int deleteUserDetails(User user) {
		String delete = "delete from user where email=? ";
		Object[] details = { user.getEmail() };
		int numberOfRows = jdbcTemplate.update(delete, details);
		System.out.println("Deleted Rows : " + numberOfRows);
		return numberOfRows;
	}

	public List<User> userList() {
		String userList = "select name,email,mobile from user";
		List<User> listUser = jdbcTemplate.query(userList, new UserMapper());
		System.out.println(listUser);
		return listUser;
	}

}
