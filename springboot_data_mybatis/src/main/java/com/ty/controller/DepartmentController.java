package com.ty.controller;

import com.ty.entity.Department;
import com.ty.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by Administrator on 2018/1/1.
 */
@RestController
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department findOneDept(@PathVariable("id") Integer id) {
        return departmentMapper.selectOneDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertOneDept(@PathParam("department") Department department) {
        departmentMapper.insertOneDept(department);
        return  department;
    }
    @GetMapping("/dept/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        departmentMapper.deleteOneDeptById(id);
        return  "1";
    }
}
