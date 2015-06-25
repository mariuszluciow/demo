package com.luciow.demo.web.service;

import com.luciow.demo.web.dao.UserDao;
import com.luciow.demo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariusz
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public void register(String login) {
        User user = new User(login);
        userDao.save(user);
    }

    @Override
    public void activate(String login) {
        User user = userDao.findByLogin(login);
        user.activate();
        userDao.save(user);
    }

}
