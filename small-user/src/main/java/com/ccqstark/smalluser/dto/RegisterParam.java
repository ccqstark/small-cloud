package com.ccqstark.smalluser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParam {

    private String role;

    private String username;

    private String password;

    private String re_password;

}
