package com.udea.Latin_Developers_Football_Club.repository;
import com.udea.Latin_Developers_Football_Club.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Long> {
}
