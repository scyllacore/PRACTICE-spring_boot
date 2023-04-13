package com.scyllacore.jblogweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import com.scyllacore.jblogweb.domain.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USERS(ID, USERNAME, PASSWORD, EMAIL) " +
            "VALUES((SELECT NVL(MAX(ID),0) + 1 FROM USERS), #{userName},#{password},#{email})") // VALUE라고 씀
    public void insertUser(User user);

    @Select("SELECT * FROM USERS WHERE USERNAME = #{userName}")
    public void getUser(User user);

    @Select("SELECT * FROM USERS ORDER BY USERNAME DESC")
    public List<User> getUserList();

    @Update("UPDATE USERS PASSWORD = #{password}, EMAIL = #{email} WHERE ID = #{id}")
    public void updateUser(User user);

    @Delete("DELETE USERS WHERE ID = #{id}")
    public void deleteUser(User user);

}
