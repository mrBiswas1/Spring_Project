package com.zepto.password.reset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.password.reset.dao.UserPasswordHistoryDAO;

@Service
public class UserPasswordHistoryService {
	
    @Autowired
    private UserPasswordHistoryDAO userPasswordHistoryDAO;

    public void saveLastThree(String userName, String lastThree) {
        userPasswordHistoryDAO.savePassword(userName, lastThree);
        userPasswordHistoryDAO.keepLastN(userName, 3);
    }

    public boolean isLastThreeUsed(String userName, String lastThree) {
        return userPasswordHistoryDAO.exist(userName, lastThree);
    }
}
