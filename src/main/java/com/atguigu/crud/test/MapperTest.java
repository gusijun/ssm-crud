package com.atguigu.crud.test;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层工作
 * @author 顾思君
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;


    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testCRUD(){
          //departmentMapper.insertSelective(new Department(null,"开发部"));
         // departmentMapper.insertSelective(new Department(null,"测试部"));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5) + i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@atguigu.com",1));
        }
    }


}
