package fr.epita.projet_paul_montagnac;

import fr.epita.projet_paul_montagnac.model.Account;
import fr.epita.projet_paul_montagnac.model.BankCard;
import fr.epita.projet_paul_montagnac.model.CardType;
import fr.epita.projet_paul_montagnac.model.Client;

public class TestClient {

  public static void main(String[] args) {
    Client client = new Client();
    client.setFirstName("Paul");
    client.setLastName("Montagnac");
    client.setAddress("rue Blanche");
    client.setPostalCode("75009");
    client.setCity("Paris");
    client.setPhone("0123456789");

    Account account1 = new Account();
    account1.setAccountType("CURRENT");
    account1.setBalance(500.0);
    account1.setClient(client);
    client.getAccounts().add(account1);

    Account account2 = new Account();
    account2.setAccountType("SAVINGS");
    account2.setBalance(1000.0);
    account2.setClient(client);
    client.getAccounts().add(account2);

    BankCard card = new BankCard();
    card.setType(CardType.VISA_PREMIER);
    card.setActive(true);
    card.setClient(client);
    client.getCards().add(card);

    System.out.println("Client: " + client.getFirstName() + " " + client.getLastName());
    System.out.println("Comptes:");
    for (Account a : client.getAccounts()) {
      System.out.println(" - " + a.getAccountType() + ", solde=" + a.getBalance());
    }
    System.out.println("Cartes:");
    for (BankCard c : client.getCards()) {
      System.out.println(" - " + c.getType() + ", actif=" + c.isActive());
    }
  }
}
