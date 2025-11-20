package fr.epita.projet_paul_montagnac.repository;

import fr.epita.projet_paul_montagnac.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
