package com.udea.Latin_Developers_Football_Club.services;
import com.udea.Latin_Developers_Football_Club.entity.Player;
import com.udea.Latin_Developers_Football_Club.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id){
        return playerRepository.findById(id).orElse(null);
    }
    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public List<Player> savePlayers(List<Player> players){
        return playerRepository.saveAll(players);
    }

    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayerOptional = playerRepository.findById(player.getId());
        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();
            existingPlayer.setName(player.getName());
            existingPlayer.setAge(player.getAge());
            return playerRepository.save(existingPlayer);
        }
        return null; // Maneja un caso de error si el jugador no existe
    }
    public String deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return "Has eliminado el jugador con el ID: " + id;
    }
}
