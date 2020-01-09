package third_solution;

import java.util.concurrent.Semaphore;

public class BankAccount {
	private double balance;
	public Semaphore balanceSemaphore = new Semaphore(1);
	public int readers = 0;
	public Semaphore readersSemaphore = new Semaphore(1);
	public Semaphore queueSemaphore = new Semaphore(1);
	
	public BankAccount(){
		
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		balance = balance+amount;
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance = balance-amount;
			
		}
		else {
			System.out.println("Balance < Amount !!");
		}
		
	}
}
