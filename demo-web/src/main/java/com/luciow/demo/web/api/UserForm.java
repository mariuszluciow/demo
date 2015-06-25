package com.luciow.demo.web.api;

/**
 *
 * @author Mariusz
 */
public class UserForm {

    private String login;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static class Builder {

        private final UserForm item;

        public Builder() {
            this.item = new UserForm();
        }

        public Builder withLogin(final String login) {
            this.item.login = login;
            return this;
        }

        public Builder withActive(final boolean active) {
            this.item.active = active;
            return this;
        }

        public UserForm build() {
            return this.item;
        }
    }

}
