package com.example.springjpamultimodulesexample.server.module.controller;

import com.example.springjpamultimodulesexample.message.module.entity.Message;
import com.example.springjpamultimodulesexample.message.module.repository.MessageRepository;
import com.example.springjpamultimodulesexample.server.module.dto.MessageDto;
import com.example.springjpamultimodulesexample.server.module.dto.UserDto;
import com.example.springjpamultimodulesexample.user.module.entity.User;
import com.example.springjpamultimodulesexample.user.module.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtoList = users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDtoList);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        List<Message> messages = messageRepository.findByUserId(user.getId());

        List<MessageDto> messageDtoList = messages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        userDto.setMessages(messageDtoList);

        return userDto;
    }

    private MessageDto convertToDto(Message message) {
        return modelMapper.map(message, MessageDto.class);
    }
}
