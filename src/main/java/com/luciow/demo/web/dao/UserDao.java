package com.luciow.demo.web.dao;

import com.luciow.demo.web.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mariusz
 */
public interface UserDao extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
