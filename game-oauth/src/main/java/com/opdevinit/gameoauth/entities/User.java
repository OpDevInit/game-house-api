package com.opdevinit.gameoauth.entities;

import java.util.HashSet;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private Long id;
    private String name;
    private String email;
    private String password;

    //Coleção de Tabela Mista, com Carregamento Automatico
    private Set<Category> dataGames = new HashSet<>();
}
