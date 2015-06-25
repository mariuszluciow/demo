package com.luciow.demo.web.service;

import com.luciow.demo.web.model.User;

/**
 *
 * @author Mariusz
 */
public interface UserService {

    void register(String login);

    void activate(String login);

    User getUser(String login);
}
