/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.service;

import com.jeso.guestbookrest.dao.UserMessageDao;
import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of UserMessageCommonService
 * It provides common UserMessage service for user
 * It uses UserMessageDao methods for processing
 * @author Jeso
 */
@Service
@Transactional
public class UserMessageCommonServiceDefaultImpl implements UserMessageCommonService{
    
    @Autowired
    private UserMessageDao dao;

    /**
     * Method for getting all UserMessages from database
     * @return List containes all UserMessages
     */
    @Override
    public List<UserMessage> getAllUserMessages() {
        List<UserMessage> result = dao.getAll();
        return result;
    }

    /**
     * Method for adding new UserMessage in database
     * @param userMessage is new UserMessage from Controller or another component from Presentation Tier
     */
    @Override
    public void addUserMessage(UserMessage userMessage) {
        dao.addUserMessage(userMessage);
    }
    
}
