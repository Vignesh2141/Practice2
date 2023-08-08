package com.neosoft.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Collation(value = "User")
public class UserModel {

    @Id
    private String userId;

    private String firstName;

    private String lastname;

    private String email;

    private String deptId;
}
