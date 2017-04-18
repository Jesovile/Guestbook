/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.dao;

import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;

/**
 *
 * @author Jeso
 */
public interface UserMessageDao {
    
    public List<UserMessage> getAll();
    public UserMessage getById(Integer messageId);
    public List<UserMessage> getByYearAndMonth(String year, String month);
    public List<UserMessage> getByAuthor(String userAuthor);
    
    public void addUserMessage(UserMessage userMessage);
    public void deleteById(Integer messageId);
    public void update(UserMessage userMessage);
    
}
