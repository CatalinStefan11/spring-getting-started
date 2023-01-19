package ro.sda.aop_example_2.service;

import org.springframework.stereotype.Service;
import ro.sda.aop_example_2.Account;
import ro.sda.aop_example_2.annotations.LoggerAudit;

@Service
public class AccountInfoService {
  
  @LoggerAudit("Account info method executed!")
  public Account getAccountInfo(){
    return new Account("1234", "Catalin", 100);
  }
  
  
}
