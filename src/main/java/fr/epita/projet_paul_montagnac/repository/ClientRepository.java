package fr.epita.projet_paul_montagnac.repository;

import fr.epita.projet_paul_montagnac.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
