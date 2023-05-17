package service;

import entity.Card;
import entity.Recycle;

import java.util.List;

public interface RecycleService {

    List<Recycle> SelectAll();

    Recycle SelectByName(String name);

    Recycle SelectById(Integer id);

    List<Recycle> SelectByUsername(String username);

    void DeleteOne(Integer id);

    void AddOne(Recycle recycle);


}
