package com.learing.Spring_jwt_jpa.repository;

import com.learing.Spring_jwt_jpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User,String> {
    User findByUserName(String userName);
}
