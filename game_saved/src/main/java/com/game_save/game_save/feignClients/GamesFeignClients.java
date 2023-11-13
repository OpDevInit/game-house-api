package com.game_save.game_save.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.game_save.game_save.entities.Games;

@Component
@FeignClient(name = "gamehouse", path = "/games")
public interface GamesFeignClients {

        @GetMapping(value = "{id}")
        ResponseEntity<Games> getGamesId(@PathVariable Integer id);
}
