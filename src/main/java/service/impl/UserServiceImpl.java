package service.impl;

import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.UserService;
import util.SqlSessionFactoryUtil;

public class UserServiceImpl implements UserService {

    SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public User login(String username, String password) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.SelectOne(username, password);
        session.close();
        return user;
    }

    @Override
    public boolean Register(User user) {
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.SelectByUsername(user.getUsername());
        if(user1 == null){
            userMapper.AddOne(user);
            session.commit();
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }
}
