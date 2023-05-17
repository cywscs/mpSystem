package service;

import entity.Card;
import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardService {


    List<Card> SelectAll();

    List<Card> SelectByName(String name);

    List<Card> SelectByUsername(String username);

    Card SelectById(Integer id);

    void AddOne(Card card);

    void DeleteOne(Integer id);

    void UpdateOne(Card card);


}
