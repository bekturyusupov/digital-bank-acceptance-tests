package co.wedevx.digitalbank.automation.ui.models;

public class AccountCard {
    private String acccountName;
    private String accountType;
    private String ownership;
    private long accountNumber;
    private String interestRate;
    private double balance;

    public AccountCard(String acccountName, String accountType, String ownership, long accountNumber, String interestRate, double balance) {
        this.acccountName = acccountName;
        this.accountType = accountType;
        this.ownership = ownership;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public String getAcccountName() {
        return acccountName;
    }

    public void setAcccountName(String acccountName) {
        this.acccountName = acccountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
