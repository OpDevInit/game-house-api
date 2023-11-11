package com.gamehouse.gamehouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamehouse.gamehouse.entities.Games;
import com.gamehouse.gamehouse.interfaces.GamesRepository;

@RestController
@Service
public class GamesServices {

    @Autowired
    public GamesRepository gamesRepository;

    public List<Games> getGames() {
        return gamesRepository.findAll();
    }

    public List<Games> findGameByName(String name) {
        return gamesRepository.findByName(name);
    }

    public Games saveGame(@RequestBody Games gamesData) {
        return gamesRepository.save(gamesData);
    }

    public Games updateGame(@RequestBody Games gamesData, Integer id) {
        gamesRepository.deleteById(id);
        return gamesRepository.save(gamesData);
    }

    public void deleteGame(Integer id) {
        gamesRepository.deleteById(id);
    }

}
