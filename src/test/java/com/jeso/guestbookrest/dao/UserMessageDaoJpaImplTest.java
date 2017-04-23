/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.dao;

import static org.junit.Assert.*;

import com.jeso.guestbookrest.entity.UserMessage;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jeso
 */
@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class UserMessageDaoJpaImplTest {
    
    @Autowired
    private UserMessageDao dao;
    
    public UserMessageDaoJpaImplTest() {
    }
    
    /**
     * Test of getAll method, of class UserMessageDaoJpaImpl.
     * The contract is "Result List can't be null". 
     * It can be empty (if table containes no messages), but it must be not null
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List<UserMessage> result = dao.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getById method, of class UserMessageDaoJpaImpl.
     * The contract is "If table containes message with this Id, result of getById() method can't be null"
     * The second requirement is "Id of result must be same with messageId parameter"
     * This test has additional logic to check existing of message with this messageId in the table
     * If this test is failed, check messageId value at first
    */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Integer messageId = 1;
        if(!idChecking(messageId)) fail("There is no message with this Id in database. Please, set existed messageId");

        //main testing logic
        UserMessage result = dao.getById(messageId);
        assertNotNull(result);
        assertEquals(result.getId(), messageId);
    }
    
    /**
     * Test of getByAuthor method, of class UserMessageDaoJpaImpl.
     */
    @Test
    public void testGetByAuthor() {
        System.out.println("getByAuthor");
        String userAuthor = "Jeso";
        
        //TODO this logig is so heavy. Consider this. Maybe it's unnecessary.
        //checking for message is contained in database
        List<UserMessage> table = dao.getAll();
        Boolean isContained = false;
        for (UserMessage userMessage : table) {
            if(userMessage.getUserAuthor().equals(userAuthor)){
                isContained = true;
                break;
            }
        }
        if(!isContained) fail("There is no message with this userAuthor in database. Please, set existed userAuthor");
            
        //main testing logic
        List<UserMessage> result = dao.getByAuthor(userAuthor);
        assertNotNull(result);
        for (UserMessage userMessage : result) {
            assertEquals(userMessage.getUserAuthor(), userAuthor);
        }
    }

    /**
     * Test of addUserMessage method, of class UserMessageDaoJpaImpl.
     */
    @Test
    public void testAddUserMessage() {
        System.out.println("addUserMessage");
        UserMessage userMessage = new UserMessage();
        userMessage.setUserAuthor("example");
        userMessage.setMessageText("empty");
        
        int beforeSize = dao.getAll().size();
        dao.addUserMessage(userMessage);
        int afterSize = dao.getAll().size();
        assertEquals(++beforeSize, afterSize);
    }

    /**
     * Test of deleteById method, of class UserMessageDaoJpaImpl.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer messageId = 1;
        
        if(!idChecking(messageId)) fail("There is no message with this Id in database. Please, set existed messageId");
        int beforeSize = dao.getAll().size();
        dao.deleteById(messageId);
        int afterSize = dao.getAll().size();
        assertEquals(--beforeSize, afterSize);
    }

    //TODO this logic is heavy. Consider this. Maybe it's unnecessary.
    //Checking by messageId for message is contained in database
    private boolean idChecking(Integer messageId){
        List<UserMessage> table = dao.getAll();
        Boolean isContained = false;
        for (UserMessage userMessage : table) {
            if(userMessage.getId().equals(messageId)){
                isContained = true;
                break;
            }
        }
        return isContained;
    }
    
}
