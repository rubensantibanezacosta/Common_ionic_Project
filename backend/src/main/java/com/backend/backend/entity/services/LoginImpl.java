package com.backend.backend.entity.services;

import com.backend.backend.entity.dao.IUsersDao;
import com.backend.backend.entity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements ILoginService {
    @Autowired
    IUsersDao iUsersDao;

    @Override
    public String login(User user) {
        String response = "";
        
        User foundedUser = new User();
        if (iUsersDao.findById(user.getEmail()).isPresent()) {
            foundedUser = (iUsersDao.findById(user.getEmail())).get();
            if (user.getPassword().equals(foundedUser.getPassword())) {
                String result = new String(Double.toString((Math.random() * (1000 - 0))));
                
                response = result;
            }
        }
        return response;

    }

}
