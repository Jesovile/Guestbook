/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.service;

import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;

/**
 *
 * @author Jeso
 */

public interface UserMessageCommonService {
    
    public List<UserMessage> getAllUserMessages();
    public List<UserMessage> getUserMessagesByYearAndMonth(String year, String month);
    public void addUserMessage(UserMessage userMessage);
    
}
