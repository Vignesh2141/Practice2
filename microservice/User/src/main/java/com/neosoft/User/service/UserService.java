package com.neosoft.User.service;

import com.neosoft.User.model.DepartmentModel;
import com.neosoft.User.model.ResponseTempleteVO;
import com.neosoft.User.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RestTemplate restTemplate;

    public void saveUser(UserModel userModel){
        mongoTemplate.save(userModel);
    }

    public UserModel getUserById(String id){
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,UserModel.class);
    }

    public ResponseTempleteVO getUserWithDepartment(String userId){
        ResponseTempleteVO vo=new ResponseTempleteVO();
        UserModel user=getUserById(userId);
        DepartmentModel department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/get/department/"+user.getDeptId(),DepartmentModel.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }

    public List<UserModel> getUsers(){
        return mongoTemplate.findAll(UserModel.class);
    }
}
