package com.hyeon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyeon.service.DbService;

@RestController
public class DbController {
    @Autowired
    DbService dbService;
     
    @RequestMapping("/")
    public @ResponseBody String controllerMain() throws Exception{
    	System.out.println("Helloworld");
        return "Hello World";
    }
 
    @RequestMapping("/now")
    public @ResponseBody String now() throws Exception{
        return dbService.getDual();
    }
    
    @RequestMapping("/count")
    public @ResponseBody String count() throws Exception{
    	dbService.getCount();
    	return "Test";
    }
}