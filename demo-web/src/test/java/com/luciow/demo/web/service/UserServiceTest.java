package com.luciow.demo.web.service;

import com.luciow.demo.web.ContextTestBase;
import com.luciow.demo.web.dao.UserDao;
import com.luciow.demo.web.model.User;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mariusz
 */
public class UserServiceTest extends ContextTestBase {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void shouldCreateUser() {
        userService.register("testLogin");

        User user = userDao.findByLogin("testLogin");
        assertThat(user).isNotNull();
        assertThat(user.getLogin()).isEqualTo("testLogin");
        assertThat(user.isActive()).isFalse();

    }
}
