public class FixedDepositAccount extends BankAccount{
    
    //Variables
    private float interest = 3; //set default
    private int duration = 6;   //set default
    private int interestChangeCounter = 0;
    private int durationChangeCounter= 0; 
    //tracker for durationInMonths and interest change once time.

    // //Constructor
    //WRONG AUTO GENERATED

    // public FixedDepositAccount(String accountHolderName, float interest, int duration) {
    //     super(accountHolderName);
    //     this.interest = interest;
    //     this.duration = duration;
    // }
    // public FixedDepositAccount(String accountHolderName, Float accountBalance, float interest, int duration) {
    //     super(accountHolderName, accountBalance);
    //     this.interest = interest;
    //     this.duration = duration;
    // }


    //constructors following the workshop paper
    public FixedDepositAccount(String accountHolderName, float accountBalance){
        super(accountHolderName, accountBalance);        
    }

    public FixedDepositAccount(String accountHolderName, float accountBalance, float interest){
        super(accountHolderName, accountBalance);
        this.interest = interest;        
    }

    public FixedDepositAccount(String accountHolderName, float accountBalance, float interest, int duration){
        super(accountHolderName, accountBalance);        
        this.interest = interest;
        this.duration = duration;
    }
    

    @Override
    public void deposit(Float depositAmount){
        //NOP
    }

    @Override
    public void withdraw(Float withdrawalAmount){
        //NOP
    }

    
    //GETTERS AND SETTERS
    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //GET BALANCE + RETURN INTEREST AMOUNT
    public float getBalance(){
        //interest is 3 if balance is 100, return 103
        //CONSIDER THE MONTHS TOO refer to WS
        return this.getAccountBalance() * ((this.interest/100.0f) * (this.duration));
    }

    public void showAccount(){
        System.out.println(this.getAccountNumber());
        System.out.println(this.getAccountHolderName());
        System.out.println(this.getAccountBalance());
    }


}
