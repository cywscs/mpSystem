package service.impl;

import entity.Card;
import mapper.CardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.CardService;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class CardServiceImpl implements CardService {

    SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public List<Card> SelectAll() {
        SqlSession session = sessionFactory.openSession();
        CardMapper cardMapper = session.getMapper(CardMapper.class);
        return cardMapper.SelectAll();
    }

    @Override
    public List<Card> SelectByName(String name) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        return mapper.SelectByName(name);
    }

    @Override
    public List<Card> SelectByUsername(String username) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        return mapper.SelectByUsername(username);
    }

    @Override
    public Card SelectById(Integer id) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        return mapper.SelectById(id);
    }

    @Override
    public void AddOne(Card card) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        mapper.AddOne(card);
        session.commit();
        session.close();
    }

    @Override
    public void DeleteOne(Integer id) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        mapper.DeleteOne(id);
        session.commit();
        session.close();
    }

    @Override
    public void UpdateOne(Card card) {
        SqlSession session = sessionFactory.openSession();
        CardMapper mapper = session.getMapper(CardMapper.class);
        mapper.UpdateOne(card);
        session.commit();
        session.close();
    }
}
