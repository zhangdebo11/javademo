package com.example.accessingdatamysql;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	@Select("SELECT  email , name, id FROM user WHERE name = #{name1}")
	User findByName(@Param("name1") String name2);

	@Select("SELECT  email , name, id FROM user")
	ArrayList<User> findAll();

	@Insert("insert into user (name, email) values (#{name}, #{email})")
	int addUser(@Param("name") String aaa, @Param("email") String bbb);

	@Delete("delete from user ")
	int deleteAll();

	@Update("update user set email='eeeeeeeeeee' ")
	int update();
}
