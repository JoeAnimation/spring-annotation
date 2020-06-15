package com.atsicau.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert() {
		String sql = "insert into `mygirl`(name, age, gender) VALUES(?, ?, ?)";
//		String name = UUID.randomUUID().toString().substring(0,5);
		jdbcTemplate.update(sql,"文思颖",18,"female");
	}
	
}