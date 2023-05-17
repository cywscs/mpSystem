package service.impl;

import entity.Card;
import entity.Recycle;
import mapper.RecycleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.RecycleService;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class RecycleServiceImpl implements RecycleService {

    SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public List<Recycle> SelectAll() {
        SqlSession session = sessionFactory.openSession();
        RecycleMapper recycleMapper = session.getMapper(RecycleMapper.class);
        return recycleMapper.SelectAll();
    }

    @Override
    public Recycle SelectByName(String name) {
        return null;
    }

    @Override
    public Recycle SelectById(Integer id) {
        SqlSession session = sessionFactory.openSession();
        RecycleMapper mapper = session.getMapper(RecycleMapper.class);
        return mapper.SelectById(id);
    }

    @Override
    public List<Recycle> SelectByUsername(String username) {
        SqlSession session = sessionFactory.openSession();
        RecycleMapper mapper = session.getMapper(RecycleMapper.class);
        return mapper.SelectByUsername(username);
    }

    @Override
    public void DeleteOne(Integer id) {
        SqlSession session = sessionFactory.openSession();
        RecycleMapper mapper = session.getMapper(RecycleMapper.class);
        mapper.DeleteOne(id);
        session.commit();
        session.close();
    }

    @Override
    public void AddOne(Recycle recycle) {
        SqlSession session = sessionFactory.openSession();
        RecycleMapper recycleMapper = session.getMapper(RecycleMapper.class);
        recycleMapper.AddOne(recycle);
        session.commit();
        session.close();
    }
}
