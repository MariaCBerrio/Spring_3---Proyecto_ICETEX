package com.udea.Latin_Developers_Football_Club.services;
import com.udea.Latin_Developers_Football_Club.entity.Club;
import com.udea.Latin_Developers_Football_Club.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> getClubById(Long clubId) {
        return clubRepository.findById(clubId);
    }
    public Club createClub(Club club) {
        // Establece el nombre del club como "Latin Developers FC" para garantizar que todos los jugadores pertenecen a este club
        club.setName("Latin Developers FC");
        return clubRepository.save(club);
    }
    public Club updateClub(Long clubId, Club updatedClub) {
        Optional<Club> existingClub = clubRepository.findById(clubId);
        if (existingClub.isPresent()) {
            Club club = existingClub.get();
            club.setName(updatedClub.getName());
            club.setCountry(updatedClub.getCountry());
            // Actualiza otros campos según sea necesario
            return clubRepository.save(club);
        }
        return null; // Maneja un caso de error si el club no existe
    }

    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }
}
