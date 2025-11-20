package fr.epita.projet_paul_montagnac.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String address;
  private String postalCode;
  private String city;
  private String phone;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<Account> accounts = new ArrayList<>();

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<BankCard> cards = new ArrayList<>();
}
