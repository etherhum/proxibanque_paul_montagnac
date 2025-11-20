package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
  @Id
  @GeneratedValue
  private Long id;
  private String accountNumber;
  private double balance;
  private LocalDate openingDate;
  private String accountType;
  private Double overdraftLimit;
  private Double interestRate;
  @ManyToOne
  private Client client;
}
