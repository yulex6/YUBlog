package com.yu.yublog.mapper;

import com.yu.yublog.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 11:30
 * @Description: TODO
 */
@Mapper
public interface UserMapper {

    @Insert("insert into yublog.user(real_id,username,password) values(#{User.id},#{User.username},#{User.password})")
    int insertUser(@Param("User") User user);

    @Select("select * from yublog.user where username = #{name};")
    @Results({
            @Result(property = "id",column = "real_id")
    })
    User queryUserByName(@Param("name") String name);

    @Select("select * from yublog.user where real_id = #{id};")
    @Results({
            @Result(property = "id",column = "real_id")
    })
    User queryUserById(@Param("id") String id);

    @Delete("delete from yublog.user where username = #{name};")
    int deleteUserByName(@Param("name") String name);

    @Select("select * from yublog.user where username = #{name} and password = #{password};")
    @Results({
            @Result(property = "id",column = "real_id")
    })
    User queryUser(@Param("name")String name,@Param("password") String password);
}
