package com.sensiple.contactsrepository.dao;

import com.sensiple.contactsrepository.persist.entity.User;

public interface UserDetailsDAO {
	User findByLogin(String login);
}
