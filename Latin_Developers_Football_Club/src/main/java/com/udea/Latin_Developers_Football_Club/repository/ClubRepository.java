package com.udea.Latin_Developers_Football_Club.repository;

import com.udea.Latin_Developers_Football_Club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository <Club, Long> {
}
