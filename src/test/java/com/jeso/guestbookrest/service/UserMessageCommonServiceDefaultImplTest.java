/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.service;

import com.jeso.guestbookrest.dao.UserMessageDao;
import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Jeso
 */
@RunWith(MockitoJUnitRunner.class)
public class UserMessageCommonServiceDefaultImplTest {
    
    @Mock
    private UserMessageDao dao;
    
    @InjectMocks
    private UserMessageCommonService service = new UserMessageCommonServiceDefaultImpl();
    
    public UserMessageCommonServiceDefaultImplTest() {
    }
    
    /**
     * Test of getAllUserMessages method, of class UserMessageCommonServiceDefaultImpl.
     */
    @Test
    public void testGetAllUserMessages() {
        System.out.println("getAllUserMessages");
        List<UserMessage> result = service.getAllUserMessages();
        verify(dao, times(1)).getAll();
        assertNotNull(result);
    }

    /**
     * Test of addUserMessage method, of class UserMessageCommonServiceDefaultImpl.
     */
    @Test
    public void testAddUserMessage() {
        System.out.println("addUserMessage");
        UserMessage userMessage = new UserMessage();
        service.addUserMessage(userMessage);
        verify(dao, times(1)).addUserMessage(userMessage);
    }
}
