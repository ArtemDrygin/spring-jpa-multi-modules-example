package com.example.springjpamultimodulesexample.message.module.repository;

import com.example.springjpamultimodulesexample.message.module.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByUserId(Long userId);
}
