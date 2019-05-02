package com.lyf.web.dao;

import com.lyf.web.model.Hero;
public interface Function {
    public Hero findById(int id);
    public void deleteById(int id);
    public void insertHero(Hero hero);
    public void updateHero(Hero hero);
}
