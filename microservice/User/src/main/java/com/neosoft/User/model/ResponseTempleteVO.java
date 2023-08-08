package com.neosoft.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTempleteVO {
    private UserModel user;

    private DepartmentModel department;
}
