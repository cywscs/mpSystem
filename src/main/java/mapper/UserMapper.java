package mapper;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    User SelectOne(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username=#{username}")
    User SelectByUsername(@Param("username") String username);

    @Insert("insert into user(username, password) values(#{username}, #{password})")
    void AddOne(User user);

}
