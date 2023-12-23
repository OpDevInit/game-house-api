package com.opdevinit.gameoauth.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opdevinit.gameoauth.entities.User;

@Component
@FeignClient(name = "gameuser", path = "/users")
public interface UserFeignClient {
    
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);

}
