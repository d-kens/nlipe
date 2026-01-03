package com.peid.modules.users.mapper;

import com.peid.modules.users.dto.CreateUserDto;
import com.peid.modules.users.dto.UpdateUserRequest;
import com.peid.modules.users.dto.UserResponse;
import com.peid.modules.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(CreateUserDto dto);
    UserResponse toResponse(User user);
    void update(UpdateUserRequest request, @MappingTarget User user);
}