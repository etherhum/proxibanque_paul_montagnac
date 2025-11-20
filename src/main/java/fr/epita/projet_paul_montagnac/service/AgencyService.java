package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Agency;
import java.util.List;
import java.util.Optional;

public interface AgencyService {
  List<Agency> getAgencies();
  Optional<Agency> getAgency(Long id);
  Agency createAgency(Agency agency);
  void deleteAgency(Long id);
}
