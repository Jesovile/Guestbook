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
 * Spring MVC Rest Controller implement user part of REST service for messages resources
 * Default URL for access is "(host name>)/rest/v1/messages" where v1 is number of public API version
 * By default Content-type is "application/json"
 * Default marshalling library is com.fasterxml.jackson
 * It uses UserMessageCommonService methods for processing
 * @author Jeso
 */

@RestController
@RequestMapping("/rest/v1/messages")
@CrossOrigin("*")
public class UserMessageRestController {
    
    @Autowired
    private UserMessageCommonService service;
    
    /**
     * Method for getting all messages by GET http-request
     * @return JSON object containes representation of all UserMessages from database
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserMessage> getAllMessages(){
        List<UserMessage> result = service.getAllUserMessages();
        return result;
    }
        
    /**
     * Method for adding new UserMessage in database by POST http-request with parameters
     * Params are required. It prevents adding of empty messages
     * @param author is the name of author. By default it's text from <input> element of form in index.jsp
     * @param messageText is the text of message. By default it's text from <textarea> element of form in index.jsp
     */
    @RequestMapping(method = RequestMethod.POST)
    public void addUserMessage(@RequestParam(name = "author", required = true) String author, 
                               @RequestParam(name = "messageText", required = true) String messageText){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserAuthor(author);
        userMessage.setMessageText(messageText);
        service.addUserMessage(userMessage);
    }
    
}
