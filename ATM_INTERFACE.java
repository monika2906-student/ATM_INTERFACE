import java.util.Scanner;
class Bank_Account {
    private double balance;
    public Bank_Account(double IBA){
        balance = IBA; //initial balance
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount) {
        balance = balance + amount;
    }
    public boolean withdraw(double amount){
        if (amount <=balance ){
            balance -= amount;
            return true;
        } else{
            return false;
        }
    }
}
class ATM{
    private Bank_Account account;
    public ATM(Bank_Account account){
        this.account = account;
    }
    public void displaymenu(){
        System.out.println(" YOU ARE WELCOME TO THE ATM");
        System.out.println(" -> 1 Check balance ");
        System.out.println(" ->2 Deposit");
        System.out.println(" ->3 Withdraw");
        System.out.println(" ->4 Exit");
    }
    public void PT(){
        Scanner sc= new Scanner(System.in);
        int choice;
        double amount;
        while(true){
            displaymenu();
            System.out.println(" ENTER YOUR CHOICE");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("YOUR BALANCE IS : Rs" + account.getBalance());
                    break;
                    case 2:
                        System.out.println(" Enter the deposit amount : Rs.");
                        amount = sc.nextDouble();
                        if (amount >0){
                            account.deposit(amount);
                            System.out.println("Deposit successfully ");
                        }else {
                            System.out.println("Invalid deposit amount: Rs");
                        }
                        break;
                case 3:
                    System.out.println(" ENTER THE WITHDRAWL AMOUNT : Rs");
                    amount = sc.nextDouble();
                    if(amount > 0 && account.withdraw(amount)){
                        System.out.println("WITHDRAWL SUCCESSFUL:");
                    }else{
                        System.out.println(" INVALID WIHDRAWL AMOUNT OR INSUFFICIENT BALANCE ");
                    }
                break;
                case 4:
                    System.out.println(" Thank you for using the ATM . GOODBYE");
                    return;
                default:
                    System.out.println("INVALID CHOICE . PLEASE TRY AGAIN");
            }

        }


    }
}

public class ATM_INTERFACE{
    public static void main(String[] args) {
        Bank_Account myAccount = new Bank_Account(200000);
        ATM atm = new ATM(myAccount);
        atm.PT();

    }
}
