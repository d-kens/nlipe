package com.peid.api.modules.users.mapper;

import com.peid.api.modules.users.dto.CreateUserDto;
import com.peid.api.modules.users.dto.UpdateUserRequest;
import com.peid.api.modules.users.dto.UserResponse;
import com.peid.api.modules.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(CreateUserDto dto);
    UserResponse toResponse(User user);
    void update(UpdateUserRequest request, @MappingTarget User user);
}