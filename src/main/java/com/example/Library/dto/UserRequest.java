package com.example.Library.dto;

import com.example.Library.enums.UserStatus;
import com.example.Library.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    private String userName;

    private String userPhone;

    @NotBlank(message = "user email must not be blank")
    private String userEmail;

    private String userAddress;

    private String password;

    public User toUser() {

        return User.
                builder().
                name(this.userName).
                email(this.userEmail).
                mobNo(this.userPhone).
                address(this.userAddress).
                userStatus(UserStatus.ACTIVE).
                build();
    }
}
