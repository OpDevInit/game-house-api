package com.game_save.game_save.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Games {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    
    private Integer id;
    
    @Column(name = "nome")
    private String name;

    @Column(name = "produtora")
    private String producer;
}
