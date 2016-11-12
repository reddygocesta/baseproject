package com.gocesta.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gocesta.dao.UserDetailsDAO;
import com.gocesta.mapper.UserDetailsRowMapper;
import com.gocesta.persist.entity.User;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User findByLogin(String userName) {
		User user = null;
		String sql = "select US.id,US.login,US.password,AU.name from users US "
				+ " INNER JOIN users_authority UA ON US.id = UA.id "
				+ " INNER JOIN authority AU ON AU.id = UA.id "
				+ " where US.login = ? ";
		try {
			user = jdbcTemplate.queryForObject(sql, new UserDetailsRowMapper(),userName);
		} catch (EmptyResultDataAccessException e) {
			user = new User();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return user;
	}

}
