package fr.epita.projet_paul_montagnac.controller;

import fr.epita.projet_paul_montagnac.model.Account;
import fr.epita.projet_paul_montagnac.model.BankCard;
import fr.epita.projet_paul_montagnac.model.CardType;
import fr.epita.projet_paul_montagnac.model.Client;
import fr.epita.projet_paul_montagnac.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
  private final ClientService service;

  @GetMapping("/clients")
  public List<Client> getClients() {
    return service.getClients();
  }

  @GetMapping("/clients/{id}")
  public ResponseEntity<Client> getClient(@PathVariable Long id) {
    return service.getClient(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/clients")
  public Client createClient(@RequestBody Client client) {
    return service.save(client);
  }

  @DeleteMapping("/clients/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    service.deleteClient(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/accounts")
  public ResponseEntity<?> addAccount(@PathVariable Long id, @RequestBody Account account) {
    try {
      Account a = service.addAccount(id, account);
      return ResponseEntity.ok(a);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{id}/accounts")
  public ResponseEntity<List<Account>> getAccounts(@PathVariable Long id) {
    try {
      List<Account> accounts = service.getAccounts(id);
      return ResponseEntity.ok(accounts);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{id}/cards")
  public ResponseEntity<?> addCard(@PathVariable Long id, @RequestBody CardType type) {
    try {
      BankCard card = service.addCard(id, type);
      return ResponseEntity.ok(card);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{id}/cards")
  public ResponseEntity<List<BankCard>> getCards(@PathVariable Long id) {
    try {
      List<BankCard> cards = service.getCards(id);
      return ResponseEntity.ok(cards);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
