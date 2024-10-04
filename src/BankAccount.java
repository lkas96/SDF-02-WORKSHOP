import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    
    //Variables
    private final String accountHolderName;
    private final Integer accountNumber;
    private Float accountBalance;
    private List<String> transactions = new ArrayList<>();
    private boolean closed;
    private LocalDate accountOpeningDate;
    private LocalDate accountClosingDate;

    //Constructors
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = (int) Math.floor((Math.random() * (10000 - 1000) + 1000)); //randomly assigned bank number
        this.accountBalance = 0.0f; //default bank opening bal
        this.closed = false; //account created
        this.accountOpeningDate = LocalDate.now(); //auto add current date
    }


    public BankAccount(String accountHolderName, Float accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance; //deposit amount during opening
        this.accountNumber = (int) Math.floor((Math.random() * (10000 - 1000) + 1000)); //randomly assigned bank number
        this.closed = false; //account created
        this.accountOpeningDate = LocalDate.now(); //auto add current date
    }


    //GETTERS
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Float getAccountBalance() {
        return accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return closed;
    }

    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public LocalDate getAccountClosingDate() {
        return accountClosingDate;
    }


    //SETTERS
    public void setAccountBalance(Float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setAccountOpeningDate(LocalDate accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public void setAccountClosingDate(LocalDate accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    //METHODS

    //DEPOSIT
    public void deposit(Float depositAmount){
        try {
            if (depositAmount > 0 || !isClosed()){
                float temp = (float) getAccountBalance();
                float temp2 = temp + depositAmount;
                setAccountBalance(temp2);
                transactions.add("Deposited $" + depositAmount + " at " + LocalDateTime.now());
            }
        } catch (IllegalArgumentException e){
            //Negative or invalid amount
            System.out.println("Deposit transaction invalid. Please try again.");
        }
        
    }

    //DEPOSIT METHODS 2 - EXAMPLE IN CLASS
    //SEPERATE THE CHECKS DEPOSIT AMOUNT AND ISCLOSED
    //SO CAN THROW SPECIFIC MESSAGE
    public void deposit2(Float depositAmount) throws IllegalAccessException{
        if (!this.isClosed()){
            //If account is active, proceed deposit
            if (depositAmount > 0.0f){
                //second check if deposit amount is positive amount and valid, proceed deposit
                this.accountBalance = this.accountBalance + depositAmount;
                transactions.add("Deposited $" + depositAmount + " at " + LocalDateTime.now());
            } else {
                throw new IllegalAccessException("Deposit amount has to be at least $0.01.");
            }
        } else {
            throw new IllegalAccessException("This account is no longer active. Thank you for banking with us.");
        }
    }

    //WITHDRAWL METHODS 2 - EXAMPLE IN CLASS
    //SEPERATE THE CHECKS WITHDRAWAL AMOUNT AND ISCLOSED
    //SO CAN THROW SPECIFIC MESSAGE
    public void withdrawal2(Float withdrawalAmount) throws IllegalAccessException{
        if (!this.isClosed()){
            //If account is active, proceed deposit
            if (withdrawalAmount <= this.accountBalance && withdrawalAmount > 0.0f){
                //second check if withdrawal amount is positive amount and valid, proceed withdrawal
                this.accountBalance = this.accountBalance + withdrawalAmount;
                transactions.add("Withdrew $" + withdrawalAmount + " at " + LocalDateTime.now());
            } else {
                throw new IllegalAccessException("Withdrawal amount has to be at least $0.01, or Withdrawal amount exceeded bank balance.");
            }
        } else {
            throw new IllegalAccessException("This account is no longer active. Thank you for banking with us.");
        }
    }

 

    //WITHDRAWAL

    public void withdraw(Float withdrawalAmount){
        try {
            if (withdrawalAmount <= getAccountBalance() || !isClosed()){
                float temp = getAccountBalance();
                float temp2 = temp - withdrawalAmount;
                setAccountBalance(temp2);
                transactions.add("Withdrew $" + withdrawalAmount + " at " + LocalDateTime.now());
            }
        } catch(IllegalArgumentException e) {
            //Withdrawal more than balance or invalid withdrawal
            System.out.println("Withdrawal transaction invalid. Please try again.");
        }
    }


    //toString auto generated.
    @Override
    public String toString() {
        return "BankAccount [accountHolderName=" + accountHolderName + ", accountNumber=" + accountNumber
                + ", accountBalance=" + accountBalance + ", transactions=" + transactions + ", closed=" + closed
                + ", accountOpeningDate=" + accountOpeningDate + ", accountClosingDate=" + accountClosingDate + "]";
    }
    



    
    
}
