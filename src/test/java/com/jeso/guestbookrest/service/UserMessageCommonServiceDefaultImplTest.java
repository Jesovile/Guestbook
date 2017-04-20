/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.service;

import com.jeso.guestbookrest.dao.UserMessageDao;
import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
     * Test of getUserMessagesByYearAndMonth method, of class UserMessageCommonServiceDefaultImpl.
     */
//    @Test
//    public void testGetUserMessagesByYearAndMonth() {
//        System.out.println("getUserMessagesByYearAndMonth");
//        String year = "";
//        String month = "";
//        UserMessageCommonServiceDefaultImpl instance = new UserMessageCommonServiceDefaultImpl();
//        List<UserMessage> expResult = null;
//        List<UserMessage> result = instance.getUserMessagesByYearAndMonth(year, month);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addUserMessage method, of class UserMessageCommonServiceDefaultImpl.
     */
    @Test
    public void testAddUserMessage() {
        System.out.println("addUserMessage");
        UserMessage userMessage = new UserMessage();
        
        try{
            service.addUserMessage(userMessage);
            verify(dao, times(1)).addUserMessage(userMessage);
        }catch (Exception e){
            fail("Exception : " + e.getClass() + "\r\n" + e.getMessage());
        }
    }
    
}
