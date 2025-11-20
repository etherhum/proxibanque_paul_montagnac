package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Account;
import fr.epita.projet_paul_montagnac.model.BankCard;
import fr.epita.projet_paul_montagnac.model.CardType;
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

  @Override
  public Account addAccount(Long clientId, Account account) {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    account.setClient(client);
    if ("CURRENT".equalsIgnoreCase(account.getAccountType())) {
      account.setOverdraftLimit(1000.0);
    } else if ("SAVINGS".equalsIgnoreCase(account.getAccountType())) {
      account.setInterestRate(3.0);
    }
    client.getAccounts().add(account);
    accountRepository.save(account);
    return account;
  }

  @Override
  public List<Account> getAccounts(Long clientId) {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    return client.getAccounts();
  }

  @Override
  public BankCard addCard(Long clientId, CardType type) {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    BankCard card = new BankCard();
    card.setClient(client);
    card.setType(type);
    card.setActive(true);
    client.getCards().add(card);
    bankCardRepository.save(card);
    return card;
  }

  @Override
  public List<BankCard> getCards(Long clientId) {
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    return client.getCards();
  }
}
