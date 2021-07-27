package com.learing.Spring_jwt_jpa.service;

import com.learing.Spring_jwt_jpa.dto.CreateUserDto;
import com.learing.Spring_jwt_jpa.entity.User;

public interface IUserService {
    User createUser(CreateUserDto user);
    User getUser(String userName);
}
