/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.controller;

import com.jeso.guestbookrest.entity.UserMessage;
import com.jeso.guestbookrest.service.UserMessageCommonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jeso
 */

@RestController
@RequestMapping("/rest/v1/messages")
@CrossOrigin("*")
public class UserMessageRestController {
    
    @Autowired
    private UserMessageCommonService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<UserMessage> getAllMessages(){
        List<UserMessage> result = service.getAllUserMessages();
        return result;
    }
    
    //TODO implement it after additional method implementation in service
    @RequestMapping(method = RequestMethod.GET, value = "/{year}/{month}")
    public List<UserMessage> getMessagesByYearAndMonth(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addUserMessage(@RequestParam("author") String author, 
                               @RequestParam("messageText") String messageText){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserAuthor(author);
        userMessage.setMessageText(messageText);
        //TODO think about adding date
        service.addUserMessage(userMessage);
    }
    
}
