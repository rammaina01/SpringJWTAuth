package com.learing.Spring_jwt_jpa.service;

import com.learing.Spring_jwt_jpa.dto.CreateUserDto;
import com.learing.Spring_jwt_jpa.entity.User;
import com.learing.Spring_jwt_jpa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository repository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User createUser(CreateUserDto createUser) {
        User user = new User();
        user.setUserName(createUser.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(createUser.getPassword()));
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setEmail(createUser.getEmail());
        user.setMobile(createUser.getMobile());

        repository.save(user);

        return repository.findByUserName(createUser.getUserName());
    }

    @Override
    public User getUser(String userName) {
        return repository.findByUserName(userName);
    }
}
