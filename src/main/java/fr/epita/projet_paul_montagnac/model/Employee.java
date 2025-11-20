package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String role;
}
