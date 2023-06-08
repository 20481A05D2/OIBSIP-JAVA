import java.util.Scanner;

class Bank_operations {
	String Userpin;
    String UserID;
    String User_Name;
    String Transaction_History= "";
    String Acc_num;
    String pwd;
    int transactions = 0;
    int balance =0;

	public boolean Acc_reg(){
        Scanner sc = new Scanner(System.in);
        boolean Sucess_reg = false;
        System.out.println("Enter the UserName(Minimum length of 8 characters please enter)");
        this.User_Name= sc.next();
        System.out.println("Enter the UserID");
        this.UserID = sc.next();
        System.out.println("Enter the 4 digits of UserPin");
        this.Userpin  = sc.next();
        System.out.println("Enter your 10 digits of your Account Number");
        this.Acc_num = sc.next();
        System.out.println("Enter the Password");
        this.pwd = sc.next();
        if (Acc_num.length()==10 && Userpin.length()==4 && User_Name.length()>=8){
            Sucess_reg = true;
        }
        else{
            Sucess_reg = false;
        }
        return Sucess_reg;
    }

	public boolean Acc_login(){
        Scanner sc = new Scanner (System.in);

        boolean login = false;
        System.out.println("Enter the USerID");
        String User_ID  = sc.next();
        if (User_ID.equals(UserID)){
            System.out.println("Enter the UserPin");
            String User_pin = sc.next();
            if (User_pin.equals(Userpin)){
                System.out.println("You have successfully Login to your accoount "+ User_Name);
                login = true;
            }
            else{
                System.out.println("Your Userpin is correctly enter.Please check your Userpin");
            }
        }
        else{
            System.out.println("UserID is not exists.Please check once your UserID");
        }
        return login;
    }
    public void accDeposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be deposited in your bank account");
        int deposit_cash = sc.nextInt();
        balance = balance+deposit_cash;
        transactions++;
        String actions = "In Account number:"+ Acc_num+"\n"+deposit_cash+ "Deposited in Account ";
        Transaction_History += actions ;
        System.out.println("In your account Rs."+ deposit_cash+" is deposited");
    }
    public void accTransfer(){
        System.out.println("Enter trasnfer acccount number of 10 digits from your account");
        Scanner sc = new Scanner(System.in);
        String trans_acc = sc.next();
        System.out.println("Enter amount to transfer");
        int trans_amount = sc.nextInt();
        if (trans_acc.length()==10 && trans_amount<=balance){
            System.out.println("You entered transfer account number is correct.");
            System.out.println("Rs."+ trans_amount+" is transferred account number as "+ trans_acc+" from your account");
            balance -= trans_amount;
            transactions++;
            String str = "\nRs."+ trans_amount+" is transferred from your bank account to "+ trans_acc;
            Transaction_History += str;

        }
        else if (trans_acc.length()!=10){
            System.out.println("You entered Wrong acccount number.Please check it once.");
        }
        else  {
            System.out.println("You have insufficient balance in your account.Please check balance");
        }
        
    }
    public void transHistory(){
        if (transactions==0)
          System.out.println("Their is no transactions occured in your bank account");
        else
           System.out.println(Transaction_History);
    }
    public void checkBalance(){
        System.out.println("Rs."+ balance+" is your bank balance");
    }
    public void accWithdraw(){
        System.out.println("Enter amount to withdraw from your accout");
        Scanner sc = new Scanner(System.in);
        int withdraw_amount =sc.nextInt();
        if (balance<withdraw_amount){
            System.out.println("You have insufficient balance for withdrawing money for your request.Please check your balance. ");
        }
        else{
            System.out.println("Rs."+ withdraw_amount+" is withdrawing from your account");
            String str = "\nRs."+ withdraw_amount+" is withdrawing from your account";
            transactions++;
            Transaction_History += str;
            balance -= withdraw_amount;
        }

    }
}
public class ATM{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("\n**********WELCOME TO  ATM SYSTEM**********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = sc.nextInt();

        if ( choice == 1 ) {
            Bank_operations b = new Bank_operations();
            if (b.Acc_reg()){
                System.out.println("You have successfully registered for your new bank account");
            }
            else{
                System.out.println("You are giving wrong information please start registration proces from starting");
                System.exit(0);
            }
            while(true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = sc.nextInt();
                if ( ch == 1 ) 
                {
                    if (b.Acc_login()) {
                        System.out.println("\n\n**********WELCOME BACK " + b.User_Name + " **********\n");

                        while (true) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = sc.nextInt();
                            switch(c) {
                                case 1:
                                b.accWithdraw();
                                break;
                                case 2:
                                b.accDeposit();
                                break;
                                case 3:
                                b.accTransfer();
                                break;
                                case 4:
                                b.checkBalance();
                                break;
                                case 5:
                                b.transHistory();
                                break;
                                default :
                                System.exit(0);

                            }
                        }
                    }
                    else {
                        System.exit(0);
                    }

                }
                else if (ch==2) {
                    System.exit(0);
                }

            }
        }
        else {
            System.exit(0);
        }

    }
}