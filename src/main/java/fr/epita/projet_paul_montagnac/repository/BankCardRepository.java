package fr.epita.projet_paul_montagnac.repository;

import fr.epita.projet_paul_montagnac.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}
