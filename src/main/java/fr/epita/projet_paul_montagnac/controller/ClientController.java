package fr.epita.projet_paul_montagnac.controller;

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
}
