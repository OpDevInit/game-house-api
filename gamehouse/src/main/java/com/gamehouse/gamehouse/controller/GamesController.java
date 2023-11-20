package com.gamehouse.gamehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamehouse.gamehouse.entities.Games;
import com.gamehouse.gamehouse.services.GamesServices;

@Controller
@RequestMapping("/games")
public class GamesController {

    @Autowired
    public GamesServices gamesServices;

    @GetMapping
    public ResponseEntity<List<Games>> getGames() {
        return ResponseEntity.ok(gamesServices.getGames());
    }

    @GetMapping("/find")
    public ResponseEntity<List<Games>> getGameByName(@RequestParam String name) {
        return ResponseEntity.ok(gamesServices.findGameByName(name));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Games> getGameById(@PathVariable Integer id) {
        return new ResponseEntity<Games>(gamesServices.findGameById(id), HttpStatus.OK);
    }

    @PostMapping("/newgame")
    public ResponseEntity<Games> saveNewGame(@RequestBody Games newGame) {
        return ResponseEntity.ok(gamesServices.saveGame(newGame));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Games> replaceGame(@RequestBody Games games, @PathVariable Integer id) {
        return ResponseEntity.ok(gamesServices.updateGame(games, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Integer id) {
        gamesServices.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
