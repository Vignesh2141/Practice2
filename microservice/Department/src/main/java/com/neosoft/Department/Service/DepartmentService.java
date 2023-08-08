package com.neosoft.Department.Service;

import com.neosoft.Department.Model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveDepartment(DepartmentModel departmentModel){
        DepartmentModel dep=departmentModel;
        mongoTemplate.save(dep);
    }

    public DepartmentModel getDepartmentById(String id){
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return  mongoTemplate.findOne(query,DepartmentModel.class);
    }

    public List<DepartmentModel> getAllDepartments(){
        return mongoTemplate.findAll(DepartmentModel.class);
    }
}
