package com.game_save.game_save.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import com.game_save.game_save.entities.Games;
import com.game_save.game_save.entities.Saves;
import com.game_save.game_save.exception.noSuchFieldError;
import com.game_save.game_save.feignClients.GamesFeignClients;
import com.game_save.game_save.repository.SaveRepository;

import lombok.Builder;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Builder
@Service
public class SaveServices {

   @Autowired
   private GamesFeignClients gamesFeignClients;
   @Autowired
   private SaveRepository saveRepository;

   public List<Saves> getSaves() {
      return saveRepository.findAll();
   }

   public ResponseEntity<Saves> getSavesById(Integer id) {
      return new ResponseEntity<Saves>(saveRepository.findById(id).orElseThrow(()-> new noSuchFieldError("savegame not found...")), HttpStatus.OK);

   }

   public ResponseEntity<Saves> getSavesWhenDatabaseIsOff(Integer id) {
      return new ResponseEntity<Saves>(
            Saves.builder().
            build(),
            HttpStatus.TEMPORARY_REDIRECT);

   }

   public Saves postNewSave(Integer gamesId, Saves savesData) {
      Games games = gamesFeignClients.getGameById(gamesId).getBody();
      Saves save = new Saves(gamesId,
            games.getName(),
            games.getProducer(),
            savesData.getNamePersonSave(),
            savesData.getLocalSaved());
      return saveRepository.save(save);

   }

   public Saves replaceSave(Integer id, Saves saveData) {
      Games games = gamesFeignClients.getGameById(id).getBody();
      Saves saves = new Saves(id,
            games.getName(),
            games.getProducer(),
            saveData.getNamePersonSave(),
            saveData.getLocalSaved());
      saves.setId(id);
      return saveRepository.save(saves);
   }

   public void deleteSave(Integer id) {
      Saves saves = saveRepository.findById(id).get();
      saveRepository.deleteById(id);
      Saves save = new Saves(id,
            saves.getName(),
            saves.getProducer(),
            null,
            null);
      saveRepository.save(save);
      save.setId(id);
   }

}
