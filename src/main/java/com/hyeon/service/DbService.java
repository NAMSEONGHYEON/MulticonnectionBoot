package com.hyeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeon.dao.DbMapper;
import com.hyeon.dao2.DbMapper2;

@Service
public class DbService {
 
    @Autowired
    DbMapper dbMapper;
    
    @Autowired
    DbMapper2 dbMapper2;
    
    public String getCount() throws Exception{
    	return dbMapper.getCount();
    }
    
    public String getCount2() throws Exception{
    	return dbMapper2.getCount2();
    }
    
    public void getdel() throws Exception{
    	dbMapper.getdel();
    }
    
    public void getins() throws Exception{
    	dbMapper2.getins();
    }
 
}