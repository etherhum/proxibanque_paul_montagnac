package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Agency;
import fr.epita.projet_paul_montagnac.model.Client;
import fr.epita.projet_paul_montagnac.model.Employee;
import java.util.List;
import java.util.Optional;

public interface AgencyService {
  List<Agency> getAgencies();
  Optional<Agency> getAgency(String id);
  Agency createAgency(Agency agency);

  Agency createAgency();

  void deleteAgency(Long id);
  Employee addAdvisor(String agencyId, Employee advisor);
  void assignClientToAdvisor(Long advisorId, Client client);
}
