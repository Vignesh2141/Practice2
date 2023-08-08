package com.neosoft.Department.Controller;

import com.neosoft.Department.Model.DepartmentModel;
import com.neosoft.Department.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "departments")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/save")
    public void saveDepartment(@RequestBody DepartmentModel departmentModel){
        departmentService.saveDepartment(departmentModel);
    }

    @GetMapping("/get/{id}")
    public DepartmentModel getDepartmentById(@PathVariable String id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/get")
    public List<DepartmentModel> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

}
