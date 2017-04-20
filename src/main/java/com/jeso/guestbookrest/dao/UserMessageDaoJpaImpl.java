/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.dao;

import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeso
 */
@Repository
@Transactional
public class UserMessageDaoJpaImpl implements UserMessageDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserMessage> getAll() {
        Query query = em.createQuery("Select m From UserMessage m");
        List<UserMessage> result = query.getResultList();
        return result;
    }

    @Override
    public UserMessage getById(Integer messageId) {
        UserMessage result = em.find(UserMessage.class, messageId);
        return result;
    }
    
    //TODO implement it later
    @Override
    public List<UserMessage> getByYearAndMonth(String year, String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserMessage> getByAuthor(String userAuthor) {
        Query query = em.createQuery("Select m From UserMessage m Where userAuthor =:author");
        query.setParameter("author", userAuthor);
        List<UserMessage> result = query.getResultList();
        return result;
    }

    @Override
    public void addUserMessage(UserMessage userMessage) {
        em.persist(userMessage);
    }

    @Override
    public void deleteById(Integer messageId) {
        UserMessage userMessage = em.find(UserMessage.class, messageId);
        em.remove(userMessage);
    }

    //TODO implement it later
    @Override
    public void update(UserMessage userMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
