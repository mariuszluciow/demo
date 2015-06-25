package com.luciow.demo.web.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Mariusz
 */
@Entity
public class User extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String login;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activationDate;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return activationDate != null;
    }

    public void activate() {
        activationDate = new Date();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

}
