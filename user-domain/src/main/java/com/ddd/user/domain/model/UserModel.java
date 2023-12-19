package com.ddd.user.domain.model;

import com.ddd.user.domain.valueobject.UserEmail;
import com.ddd.user.domain.valueobject.UserName;
import com.ddd.user.domain.valueobject.UserPassword;
import com.ddd.user.domain.valueobject.UserUsername;
import org.ddd.shared.domain.AggregateRoot;
import org.ddd.shared.domain.valueobject.UserId;

public class UserModel implements AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserEmail email;
    private final UserPassword password;
    private final UserUsername username;

    private UserModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.username = builder.username;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public UserEmail getEmail() {
        return email;
    }

    public UserPassword getPassword() {
        return password;
    }

    public UserUsername getUsername() {
        return username;
    }

    public static final class Builder {
        private UserId id;
        private UserName name;
        private UserEmail email;
        private UserPassword password;
        private UserUsername username;

        private Builder() {
        }

        public Builder id(UserId id) {
            this.id = id;
            return this;
        }

        public Builder name(UserName name) {
            this.name = name;
            return this;
        }

        public Builder email(UserEmail email) {
            this.email = email;
            return this;
        }

        public Builder password(UserPassword password) {
            this.password = password;
            return this;
        }

        public Builder username(UserUsername username) {
            this.username = username;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }

}