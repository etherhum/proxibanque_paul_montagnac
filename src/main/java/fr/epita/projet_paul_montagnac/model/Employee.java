package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private EmployeeRole role;

  @ManyToOne
  private Agency agency;

  @OneToMany(mappedBy = "advisor")
  private List<Client> clients = new ArrayList<>();
}
