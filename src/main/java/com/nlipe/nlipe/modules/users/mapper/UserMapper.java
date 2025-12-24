package com.nlipe.nlipe.modules.users.mapper;

import com.nlipe.nlipe.modules.users.dto.CreateUserDto;
import com.nlipe.nlipe.modules.users.dto.UpdateUserRequest;
import com.nlipe.nlipe.modules.users.dto.UserResponse;
import com.nlipe.nlipe.modules.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDto dto);
    UserResponse toResponse(User user);
    void update(UpdateUserRequest request, @MappingTarget User user);
}