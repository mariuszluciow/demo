package com.luciow.demo.web.controller;

import com.luciow.demo.web.api.UserForm;
import com.luciow.demo.web.model.User;
import com.luciow.demo.web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import static net.logstash.logback.marker.Markers.append;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void register(@RequestBody UserForm form) {
        userService.register(form.getLogin());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{login}")
    public void register(@PathVariable String login) {
        LOGGER.info(
                append("loginLength", login.length())
                .and(append("login", login)),
                "Registered {}", login
        );
        userService.activate(login);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{login}")
    public UserForm getUser(@PathVariable String login, HttpServletRequest httpRequest) {
        String ipAddress = httpRequest.getHeader("X-FORWARDED-FOR");
        LOGGER.debug("Ip from header: {}", ipAddress);
        if (ipAddress == null) {
            ipAddress = httpRequest.getRemoteAddr();
        }
        LOGGER.info("IP-{}", ipAddress);

        User user = userService.getUser(login);
        return new UserForm.Builder()
                .withActive(user.isActive())
                .withLogin(user.getLogin())
                .build();
    }
}
