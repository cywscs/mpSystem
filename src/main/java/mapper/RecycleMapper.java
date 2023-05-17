package mapper;

import entity.Card;
import entity.Recycle;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecycleMapper {

    @Select("select * from recycle")
    List<Recycle> SelectAll();

    @Select("select * from recycle where name=#{name}")
    Recycle SelectByName(@Param("name") String name);

    @Select("select * from recycle where id=#{id}")
    Recycle SelectById(@Param("id") Integer id);

    @Select("select * from recycle where username=#{username}")
    List<Recycle> SelectByUsername(@Param("username") String username);

    @Delete("delete from recycle where id=#{id}")
    void DeleteOne(@Param("id") Integer id);

    @Insert("insert into recycle values(null, #{name}, #{age}, #{sex}, #{username}, #{password}, #{email})")
    void AddOne(Recycle recycle);
}
