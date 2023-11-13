package com.game_save.game_save.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game_save.game_save.entities.Saves;

@Repository
public interface SaveRepository extends JpaRepository<Saves, Integer> {

}
