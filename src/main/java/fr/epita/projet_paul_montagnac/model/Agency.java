package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Agency {
  @Id
  private String id;
  private LocalDate creationDate;
  @OneToOne
  private Employee manager;
}
