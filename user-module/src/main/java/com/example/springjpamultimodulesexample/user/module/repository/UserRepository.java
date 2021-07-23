package com.example.springjpamultimodulesexample.user.module.repository;

import com.example.springjpamultimodulesexample.user.module.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();
}
