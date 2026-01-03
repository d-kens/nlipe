package com.peid.api.modules.users.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String phone;
    private String email;
    private String userName;
}