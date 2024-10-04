public class Program{
    public static void main(String[]args){

        BankAccount lawsonAccount = new BankAccount("Lawson");
        lawsonAccount.deposit(420.69f);

        BankAccount skyAccount = new BankAccount("Sky", 999f);

        lawsonAccount.toString();
        skyAccount.toString();



        FixedDepositAccount earlFixedDepositAccount = new FixedDepositAccount("Earl", 10000f);
        earlFixedDepositAccount.withdraw(1111f);
        earlFixedDepositAccount.deposit(22.22f);
        earlFixedDepositAccount.showAccount();

    }
}