package fr.epita.projet_paul_montagnac.controller;

import fr.epita.projet_paul_montagnac.model.Agency;
import fr.epita.projet_paul_montagnac.service.AgencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agencies")
public class AgencyController {
  private final AgencyService service;

  @GetMapping
  public List<Agency> getAgencies() {
    return service.getAgencies();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Agency> getAgency(@PathVariable Long id) {
    return service.getAgency(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Agency createAgency() {
    return service.createAgency(new Agency());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
    service.deleteAgency(id);
    return ResponseEntity.noContent().build();
  }
}
