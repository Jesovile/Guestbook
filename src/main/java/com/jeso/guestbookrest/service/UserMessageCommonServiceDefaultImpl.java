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
 *
 * @author Jeso
 */
@Service
@Transactional
public class UserMessageCommonServiceDefaultImpl implements UserMessageCommonService{
    
    @Autowired
    private UserMessageDao dao;

    @Override
    public List<UserMessage> getAllUserMessages() {
        List<UserMessage> result = dao.getAll();
        return result;
    }

    //TODO implement it after implementation additional method in UserMessageDao
    @Override
    public List<UserMessage> getUserMessagesByYearAndMonth(String year, String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserMessage(UserMessage userMessage) {
        dao.addUserMessage(userMessage);
    }
    
}
