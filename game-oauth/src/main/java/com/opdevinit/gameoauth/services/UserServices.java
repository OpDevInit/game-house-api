package com.opdevinit.gameoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.opdevinit.gameoauth.entities.User;
import com.opdevinit.gameoauth.feignClient.UserFeignClient;

@Service
public class UserServices {

    final static Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error(email, "Email Not Found");
            throw new IllegalArgumentException("Email Not Found");
        }
        logger.info("Email Found", user);
        return user;
    }

}
