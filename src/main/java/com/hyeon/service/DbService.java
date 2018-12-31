package com.hyeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeon.dao.DbMapper;

@Service
public class DbService {
 
    @Autowired
    DbMapper dbMapper;
 
    /* select dual */
    public String getDual() throws Exception{
        return dbMapper.getDual();
    }
    
    public String getCount() throws Exception{
    	return dbMapper.getCount();
    }
 
}