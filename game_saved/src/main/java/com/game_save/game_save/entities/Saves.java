package com.game_save.game_save.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Saves {
    @Id
    private Integer id;
    private String name;
    private String producer;
    @Column(name = "personagem_no_jogo")
    private String namePersonSave;
    @Column(name = "local_de_salvamento")
    private String localSaved;

    public Saves(Integer id, String name, String producer, String namePersonSave, String localSaved) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.namePersonSave = namePersonSave;
        this.localSaved = localSaved;
    }

    public Saves(String namePersonSave, String localSaved) {
       this.namePersonSave = namePersonSave;
        this.localSaved = localSaved;
    }

}
