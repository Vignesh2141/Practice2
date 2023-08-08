package com.neosoft.User.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@NoArgsConstructor
@Collation
public class DepartmentModel {
    @Id
    private String depId;

    private String departmentName;

    private String departmentCode;

    private String departmentAddress;
}
