package com.game_save.game_save;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableFeignClients
@SpringBootApplication
public class GameSaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameSaveApplication.class, args);
	}

}
