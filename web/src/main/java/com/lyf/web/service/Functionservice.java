package com.lyf.web.service;

import com.lyf.web.model.Hero;

import java.util.List;

public interface Functionservice {
    public List<Hero> findAll();
    public Hero findById(int id);
    public void deleteById(int id);
    public void insertHero(Hero hero);
    public void updateHero(Hero hero);
}
