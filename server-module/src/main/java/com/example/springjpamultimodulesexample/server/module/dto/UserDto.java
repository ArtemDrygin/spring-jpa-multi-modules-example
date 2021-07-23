package com.example.springjpamultimodulesexample.server.module.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private List<MessageDto> messages;
}
