/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeso.guestbookrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring MVC controller for root path "/"
 * @author Jeso
 */
@Controller
public class StartPageController {
    
    /**
     * Method for processing first request from client
     * @return logical name of index.jsp view
     * @see servlet-context.xml InternalResourceViewResolver configuration
     */
    @RequestMapping("/")
    public String loadStartPage(){
        return "index";
    }
}
