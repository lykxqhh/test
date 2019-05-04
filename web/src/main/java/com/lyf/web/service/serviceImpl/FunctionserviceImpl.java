package com.lyf.web.service.serviceImpl;

import com.lyf.web.dao.Function;
import com.lyf.web.model.Hero;
import com.lyf.web.service.Functionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionserviceImpl implements Functionservice {
    @Autowired
    private Function fuction;


    @Override
    public List<Hero> findAll() {
        return fuction.findAll();
    }

    @Override
    public Hero findById(int id) {
        return fuction.findById(id);
    }

    @Override
    public void deleteById(int id) {
        fuction.deleteById(id);
    }

    @Override
    public void insertHero(Hero hero) {
        fuction.insertHero(hero);
    }

    @Override
    public void updateHero(Hero hero) {
        fuction.updateHero(hero);
    }
}
