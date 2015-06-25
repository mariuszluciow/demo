package com.luciow.demo.web.controller;

import com.luciow.demo.web.api.UserForm;
import com.luciow.demo.web.model.User;
import com.luciow.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mariusz
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void register(@RequestBody UserForm form) {
        userService.register(form.getLogin());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{login}")
    public void register(@PathVariable String login) {
        userService.activate(login);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{login}")
    public UserForm getUser(@PathVariable String login) {
        User user = userService.getUser(login);
        return new UserForm.Builder()
                .withActive(user.isActive())
                .withLogin(user.getLogin())
                .build();
    }
}
