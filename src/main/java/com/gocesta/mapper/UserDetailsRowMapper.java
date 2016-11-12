package com.gocesta.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

import com.gocesta.persist.entity.Authority;
import com.gocesta.persist.entity.User;

public class UserDetailsRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNo) throws SQLException {

		User user = new User();
		user.setId(rs.getInt("id"));
		user.setPassword(rs.getString("password"));
		user.setLogin(rs.getString("login"));

		Authority userRole = new Authority();
		userRole.setName(rs.getString("name"));
		Set<Authority> userSet = new HashSet<Authority>();
		userSet.add(userRole);
		user.setAuthorities(userSet);
		return user;

	}

}
