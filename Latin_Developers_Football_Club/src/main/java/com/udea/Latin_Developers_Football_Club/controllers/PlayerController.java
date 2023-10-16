package com.udea.Latin_Developers_Football_Club.controllers;
import com.udea.Latin_Developers_Football_Club.entity.Player;
import com.udea.Latin_Developers_Football_Club.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/Players") // Obtiene la lista de jugadores.
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/Players/{id}") //  Obtiene un jugador por su ID.
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping ("addPlayer") //Crea un nuevo jugador.
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @PatchMapping("updatePlayer/{id}") //Actualiza un jugador existente.
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        player.setId(id);
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletePlayer/{id}") //Elimina un jugador por su ID.
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        String message = playerService.deletePlayer(id);
        return ResponseEntity.ok(message);
    }
}
