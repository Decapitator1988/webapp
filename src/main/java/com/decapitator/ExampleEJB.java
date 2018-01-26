package com.decapitator;


import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ExampleEJB {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public boolean checkPassword(String login, String passwod){
        if (StringUtils.isEmpty(login)||StringUtils.isEmpty(passwod)){
            return false;
        }
        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if (userEntity==null){
            return false;
        }
        if (passwod.equals(userEntity.getPassword())){
            return true;
        }
        return false;
    }
}
