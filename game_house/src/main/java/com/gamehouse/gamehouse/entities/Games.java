package com.gamehouse.gamehouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Games {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "produtora")
    private String producer;

    public Games(Integer id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

}
