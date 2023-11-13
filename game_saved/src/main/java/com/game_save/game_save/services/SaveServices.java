package com.game_save.game_save.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.game_save.game_save.entities.Games;
import com.game_save.game_save.entities.Saves;
import com.game_save.game_save.feignClients.GamesFeignClients;
import com.game_save.game_save.repository.SaveRepository;

@Service
public class SaveServices {
   private GamesFeignClients gamesFeignClients;

   private SaveRepository saveRepository;

    public Saves getSaves(@RequestParam Integer gamesId,float timeGameSaves, String localGameSaved){
        Games games = gamesFeignClients.getGamesId(gamesId).getBody();
        saveRepository.findById(gamesId);
        return new Saves(gamesId, games.getName(), games.getProducer(), timeGameSaves, localGameSaved);
    }

    public Saves postNewSave(@RequestParam Integer gamesId,@RequestBody float timeGameSaves,@RequestBody String localGameSaved){
       Games games = gamesFeignClients.getGamesId(gamesId).getBody();
       Saves newSave = new Saves(gamesId,games.getName(), games.getProducer(), timeGameSaves, localGameSaved);
       return saveRepository.save(newSave);
    }
}
