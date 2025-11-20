package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Client;
import fr.epita.projet_paul_montagnac.repository.AccountRepository;
import fr.epita.projet_paul_montagnac.repository.BankCardRepository;
import fr.epita.projet_paul_montagnac.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
  private final ClientRepository clientRepository;
  private final AccountRepository accountRepository;
  private final BankCardRepository bankCardRepository;

  @Override
  public List<Client> getClients() {
    return clientRepository.findAll();
  }

  @Override
  public Optional<Client> getClient(Long id) {
    return clientRepository.findById(id);
  }

  @Override
  public Client save(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public void deleteClient(Long id) {
    Client c = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    bankCardRepository.deleteAll(c.getCards());
    accountRepository.deleteAll(c.getAccounts());
    clientRepository.delete(c);
  }
}
