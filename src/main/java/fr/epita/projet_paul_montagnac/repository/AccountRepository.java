package fr.epita.projet_paul_montagnac.repository;

import fr.epita.projet_paul_montagnac.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
