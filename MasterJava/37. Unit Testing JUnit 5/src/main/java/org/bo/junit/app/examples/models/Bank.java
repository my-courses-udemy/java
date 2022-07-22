package org.bo.junit.app.examples.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        account.setBank(this);
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transfer(Account origen, Account source, BigDecimal amount) {
        origen.debit(amount);
        source.credit(amount);
    }
}
