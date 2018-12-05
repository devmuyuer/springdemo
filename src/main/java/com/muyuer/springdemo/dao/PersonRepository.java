package com.muyuer.springdemo.dao;


import com.muyuer.springdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 这个PersonRepository接口的功能，与SSM框架中 dao 层接口功能有异曲同工之妙；在SSM框架中，Service层通过该接口，间接执行Mybatis数据库映射文件(.xml)里的相应sql语句，执行数据库增删改查的操作。(Mapper自动实现DAO接口)
 * @author  by muyuer
 * @date : 2018-11-30 14:22
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
    /**
     *  通过年龄来查询
     *  方法名固定
     * @param age
     * @return
     */
    public List<Person> findByAge(Integer age);
}
