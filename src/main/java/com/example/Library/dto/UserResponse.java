package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserResponse {

    private String userName;

    private String userPhone;

    private String userEmail;

    private String userAddress;
}
