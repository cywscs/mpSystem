package mapper;

import entity.Card;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CardMapper {

    @Select("select * from card")
    List<Card> SelectAll();

    @Select("select * from card where name like concat('%', #{name}, '%')")
    List<Card> SelectByName(@Param("name") String name);

    @Select("select * from card where username=#{username}")
    List<Card> SelectByUsername(@Param("username") String username);

    @Select("select * from card where id=#{id}")
    Card SelectById(@Param("id") Integer id);

    @Insert("insert into card values(null, #{name}, #{age}, #{sex}, #{username}, #{password}, #{email})")
    void AddOne(Card card);

    @Update("update card set name=#{name}, age=#{age}, sex=#{sex}, email=#{email} where id=#{id}")
    void UpdateOne(Card card);

    @Delete("delete from card where id=#{id}")
    void DeleteOne(@Param("id") Integer id);


}
