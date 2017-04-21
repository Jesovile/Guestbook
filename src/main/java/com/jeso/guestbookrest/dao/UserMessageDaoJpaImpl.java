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
 * UserMessageDao interface implementation
 * This implementation based on JPA
 * @author Jeso
 */
@Repository
@Transactional
public class UserMessageDaoJpaImpl implements UserMessageDao{
    
    @PersistenceContext
    private EntityManager em;

     /**
     * This is main getting method
     * Default ordering for showing messages is inverse
     * @return List with all messages from database
     */
    @Override
    public List<UserMessage> getAll() {
        Query query = em.createQuery("SELECT m FROM UserMessage m ORDER BY m.creationDate DESC");
        List<UserMessage> result = query.getResultList();
        return result;
    }

    /**
     * Method for getting single message 
     * @param messageId is id of target UserMessage
     * @return single UserMessage with messageId
     */
    @Override
    public UserMessage getById(Integer messageId) {
        UserMessage result = em.find(UserMessage.class, messageId);
        return result;
    }
  
    /**
     * This method is for getting messages, writed by one author
     * Method for Admin module
     * @param userAuthor is the name of user corresponding to the value of UserMessage same-named field
     * @return List with messages written by user with userAuthor name
     */
    @Override
    public List<UserMessage> getByAuthor(String userAuthor) {
        Query query = em.createQuery("SELECT m FROM UserMessage m WHERE userAuthor =:author");
        query.setParameter("author", userAuthor);
        List<UserMessage> result = query.getResultList();
        return result;
    }

    /**
     * Default method for adding message in database
     * @param userMessage is the message user wants to add
     */
    @Override
    public void addUserMessage(UserMessage userMessage) {
        em.persist(userMessage);
    }

    /**
     * Default method for deleting message from database
     * Method for Admin module
     * @param messageId is id of message user wants to delete
     */
    @Override
    public void deleteById(Integer messageId) {
        UserMessage userMessage = em.find(UserMessage.class, messageId);
        em.remove(userMessage);
    }

    //TODO implement it later
    //This method for Admin module. It will be implemented with Admin module
    @Override
    public void update(UserMessage userMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
