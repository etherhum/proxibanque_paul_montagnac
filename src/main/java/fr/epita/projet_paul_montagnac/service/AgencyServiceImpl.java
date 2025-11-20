package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Agency;
import fr.epita.projet_paul_montagnac.repository.AgencyRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
  private final AgencyRepository repository;

  @Override
  public List<Agency> getAgencies() {
    return repository.findAll();
  }

  @Override
  public Optional<Agency> getAgency(Long id) {
    return repository.findById(id);
  }

  @Override
  public Agency createAgency(Agency agency) {
    return null; // TODO finir
  }

  @Override
  public void deleteAgency(Long id) {
    repository.deleteById(id);
  }

  private String generateAgencyId() {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder sb = new StringBuilder();
    Random r = new Random();
    for (int i = 0; i < 5; i++) {
      sb.append(chars.charAt(r.nextInt(chars.length())));
    }
    return sb.toString();
  }

}
