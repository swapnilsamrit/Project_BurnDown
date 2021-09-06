package com.burn.com.burn.exceptions;

public class LoginException extends Throwable {
    public LoginException(String unauthorized_user) {
        super(unauthorized_user);
    }
}
