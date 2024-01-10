package com.example.mesi.mapper;


import com.example.mesi.dto.SignUpDto;
import com.example.mesi.dto.UserDto;
import com.example.mesi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
@Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
