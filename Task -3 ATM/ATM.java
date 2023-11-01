import java.util.Scanner;


public class ATM {

    public static class BankAccount{
        private double balance;
    
        public BankAccount (double balance){
            this.balance = balance;
        }

        public boolean withdraw (double amount) {
            if (balance < amount){
                System.out.println("Insuficient Balance. Please check amount and try again");
                return false;
            }
            balance -= amount;
            System.out.print("Updated Balance: "+ balance+ "\n");
            return true;
        }

        public boolean deposit(double amount){
            balance += amount;
            System.out.print("Updated Balance: "+ balance+ "\n");
            return true;
        }

        public void checkBalance() {
            System.out.print("Current Balance: "+ balance+ "\n");
        }        
    }

    public static class Atm{
        private BankAccount userAccount;
        private Scanner input;


        public Atm(BankAccount account){
            this.userAccount = account;
            this.input = new Scanner(System.in);
        }

        private void menu(){
            System.out.print("\nWelcome.\n"+
                             "Please select one of the option from below by entering the number\n"+
                             "1. Check Balance\n"+
                             "2. Withdraw\n"+
                             "3. Deposit\n"+
                             "4. exit");
        }

        private void operation(){
            int choice;
            do{
                menu();
                System.out.print("\nEnter your choice: ");
                choice = input.nextInt();
                double amount;
            
                switch (choice){
                    case 1:
                        userAccount.checkBalance();
                        break;
                    case 2:
                        System.out.println("\nPlease Enter the amount you wish to withdraw: ");
                        amount = input.nextInt();
                        if (userAccount.withdraw(amount)){
                            System.out.println("Withdrawal successful.");
                        }
                        break;
                    case 3:
                        System.out.print("\nPlease enter the amount you wish to deposit in your account: ");
                        amount = input.nextInt();
                        userAccount.deposit(amount);
                        break;
                    case 4:
                        System.out.println("Exiting the ATM. Thank you...");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again");
                }       
            }while (choice!=4);
        }
    }

    public static void main(String[] args){
        BankAccount bank = new BankAccount(10000.00);
        Atm atm = new Atm(bank);
        atm.operation();
    }
}