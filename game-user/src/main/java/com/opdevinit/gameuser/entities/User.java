package com.opdevinit.gameuser.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_games")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    //Coleção de Tabela Mista, com Carregamento Automatico
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_game_category",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="category_id")    
    )
    private Set<Category> roles = new HashSet<>();
}
