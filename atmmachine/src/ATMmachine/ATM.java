package ATMmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class ATM {
	
	Map<Double,String> maniset=new HashMap<>();
	Atmgetset atm = new Atmgetset();
	public void viewBalance()
	{
	//Atmgetset atm = new Atmgetset();
	
	System.out.println(" The Available  Balance : " + atm.getBalance());
	
	
	}
	
	public void withdrawAmount(double withdrawAmount)

	{
		//Atmgetset atm = new Atmgetset();  //Atmgetset object
		System.out.println( "Withdrawn Operation :" );
		maniset.put(withdrawAmount, "Amount Withdrawn");
		//System.out.println("The withdrawing Amount is : " + withdrawAmount);
		if (atm.getBalance() >= withdrawAmount) {
		atm.setBalance(atm.getBalance()- withdrawAmount);
		System.out.println( "Please collect your money and remove the card" );
		viewBalance();
		}
		else {
		System.out.println( "Sorry! the balanace is insufficient." );
		System.out.println( );
		}
		
		}
	

	public void depositeAmount(double depositeAmount)
	 {
		//Atmgetset atm = new Atmgetset();
	   System.out.println( "Deposit Operation :" );
	   maniset.put(depositeAmount, "Amount deposite");
	   //System.out.println(" The depositing amount is : " + depositeAmount);
	   
	   atm.setBalance(atm.getBalance()+depositeAmount);
		//viewBalance();
	   System.out.println( "Your Money has been successfully deposited" );
	   viewBalance();
	   
	}
	public void viewMiniStatement() {
//		// TODO Auto-generated method stub
        for(Map.Entry<Double,String> m:maniset.entrySet()) {
		System.out.println(m.getKey()+" "+m.getValue());
	}

	}

	
   public static void main(String[] args) {
		// TODO Auto-generated method stub
	ATM at=new ATM();  //ATM class object
	//Atmgetset atm=new Atmgetset(); // Atm get set method  class object
	//Map<Double,String> maniset=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    
    int pin=1234;
    int tries=1;  
    System.out.println("********* WELCOME THE WORLD OF ATM ********** ");
    System.out.println("Enter Your PIN:");
    int entry=sc.nextInt();
    while(entry!=pin && tries<3) {
    	System.out.println("\n Incorrect PIN.Try Again.");
    	System.out.println("Enter your PIN");
    	entry=sc.nextInt();
    	tries++;
    }
        if(entry ==pin) {
    	System.out.println("\n PIN Accepted.Access Granted");
        
    while(true) {
    	System.out.println("********** WELCOME WELCOME WELCOME **********");
    	System.out.println( "Welcome to ATM ... " );
    	System.out.println( "Select 1 for Withdraw" );
    	System.out.println( "Select 2 for Deposit" );
    	System.out.println( "Select 3 for Check Balance" );
    	System.out.println( "Select 4 View balance Details");
    	System.out.println( "Select 5 for EXIT" );
    	System.out.print( "Select the appropriate options you want to perform:" );
    	
    	int op=sc.nextInt();
    	switch(op) {
    	  case 1:
    		  System.out.println("Enter the amount to be withdrawn :");
    		  double withdrawAmount=sc.nextDouble();
				at.withdrawAmount(withdrawAmount);
    		  break;
    	   case 2:
    		   System.out.print( "Enter the amount to be deposited :" );
    		   double depositeAmount=sc.nextDouble();
				at.depositeAmount(depositeAmount);
    		  break;
    	   case 3:
    		   
    		   at.viewBalance();
    		   System.out.println(" ");
    		   break;
    	   case 4:
    		   at.viewMiniStatement();
    		   break;
    	   case 5:
    		   System.out.println("Collect Your Atm Card\n Thank You For Visiting!!");
    		   System.exit(0);
    	}
    }
  }
    	else if(tries>=3) {
    		System.out.println("\n You have run out of tries.Account Locked.");
    
                          }
    		
	}
}

