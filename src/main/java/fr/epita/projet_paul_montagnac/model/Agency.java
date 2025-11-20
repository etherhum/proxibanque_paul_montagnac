package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agency {
  @Id
  private String id;
  private LocalDate creationDate;

  @OneToMany(mappedBy = "agency")
  private List<Employee> advisors = new ArrayList<>();
}
