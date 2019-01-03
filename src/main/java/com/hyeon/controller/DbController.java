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
 
    @RequestMapping("/count")
    public @ResponseBody String count() throws Exception{
    	String test01 = dbService.getCount();
    	String test02 = dbService.getCount2();
    	
    	System.out.println("test01_sample의 쿼리 갯수 : " + test01);
    	System.out.println("test02_sample의 쿼리 개수 : " + test02);
    	
    	return "Test";
    }
    
    @RequestMapping("/del")
    public String del() throws Exception{
    	
    	try {
    		dbService.getdel();
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
    	return "success";
    }
    
    @RequestMapping("/ins")
    public String ins() throws Exception{
    	try {
    		dbService.getins();
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
    	return "success";
    }
    
    @RequestMapping("/insdel")
    public String insdel() throws Exception{
    	try {
        	dbService.getdel();
    		dbService.getins();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
    	return "success";
    }
}