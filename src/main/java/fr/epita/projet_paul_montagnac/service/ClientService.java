package fr.epita.projet_paul_montagnac.service;

import fr.epita.projet_paul_montagnac.model.Account;
import fr.epita.projet_paul_montagnac.model.BankCard;
import fr.epita.projet_paul_montagnac.model.CardType;
import fr.epita.projet_paul_montagnac.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {
  List<Client> getClients();
  Optional<Client> getClient(Long id);
  Client save(Client client);
  void deleteClient(Long id);

  Account addAccount(Long clientId, Account account);
  List<Account> getAccounts(Long clientId);
  BankCard addCard(Long clientId, CardType type);
  List<BankCard> getCards(Long clientId);
}