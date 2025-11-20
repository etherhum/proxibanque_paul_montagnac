package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BankCard {
  @Id
  @GeneratedValue
  private Long id;

  @Enumerated(EnumType.STRING)
  private CardType type;

  private boolean active = true;

  @ManyToOne
  private Client client;
}
