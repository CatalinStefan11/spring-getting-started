package ro.sda.aop_example_2;


public class Account {
  String iban;
  String clientName;
  int balance;

  public Account(String iban, String clientName, int balance) {
    this.iban = iban;
    this.clientName = clientName;
    this.balance = balance;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
