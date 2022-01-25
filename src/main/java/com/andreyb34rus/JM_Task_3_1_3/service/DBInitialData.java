package com.andreyb34rus.JM_Task_3_1_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInitialData {

    @Autowired
    UserService userService;

    @PostConstruct
    public void setData() {
        userService.setInitData();
    }
}
