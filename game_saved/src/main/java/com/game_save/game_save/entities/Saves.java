package com.game_save.game_save.entities;

import lombok.Data;

@Data
public class Saves {
    private Integer id;
    private String name;
    private String producer;
    private float timeSaved;
    private String localSaved;


    public Saves(Integer id, String name, String producer, float timeSaved, String localSaved) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.timeSaved = timeSaved;
        this.localSaved = localSaved;
    }
   

}
