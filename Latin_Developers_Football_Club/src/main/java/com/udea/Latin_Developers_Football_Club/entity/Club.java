package com.udea.Latin_Developers_Football_Club.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "LatinDevelopersFC")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String country;

//    @OneToMany  mapea la relación de uno a muchos entre Club y Player.
    @OneToMany(mappedBy = "club")
    private List<Player> players;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
