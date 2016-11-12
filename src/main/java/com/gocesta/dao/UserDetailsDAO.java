package com.gocesta.dao;

import com.gocesta.persist.entity.User;

public interface UserDetailsDAO {
	User findByLogin(String login);
}
