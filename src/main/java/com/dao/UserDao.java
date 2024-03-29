package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository // singleton db
public class UserDao {

	// spring jdbc -> jar
	// JdbcTemplate

	@Autowired // no need to use new keyword
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		// db -> insert update delete
		stmt.update("insert into users2 (firstName,email,password,profile) values (?,?,?,?)", user.getFirstName(),
				user.getEmail(), user.getPassword(), user.getProfile()); // insert update delete

		System.out.println("USER ADDED ");
	}

	public List<UserBean> getAllUsers() {
		// query
		List<UserBean> users = stmt.query("select * from users2", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public void deleteUser(Integer userId) {
		stmt.update("delete from users2 where userId = ?", userId);
	}

	public UserBean getUserById(Integer userId) {
		return stmt.queryForObject("select * from users2 where userId = ?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), userId);
	}

	public void updateUser(UserBean user) {
		stmt.update("update users2 set firstName = ? where userId  = ?", user.getFirstName(), user.getUserId());

	}

	public UserBean getUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return stmt.queryForObject("select * from users2 where email = ?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), email);
		} catch (Exception e) {
			return null;
		}
	}
}
