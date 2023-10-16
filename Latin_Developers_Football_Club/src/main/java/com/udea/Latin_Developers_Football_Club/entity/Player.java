package com.udea.Latin_Developers_Football_Club.entity;
import jakarta.persistence.*;

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

//  @ManyToOne  mapea la relación de muchos a uno entre dos Player y Club.
//  @JoinColum especifica la columna en la tabla de la base de datos que se utilizará para mapear la relación entre Player y Club
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
