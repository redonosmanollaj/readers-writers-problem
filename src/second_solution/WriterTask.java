package second_solution;


public class WriterTask implements Runnable{
	private BankAccount bankAccount;
	private double amount;
	
	public WriterTask(BankAccount bankAccount, double amount) {
		this.bankAccount = bankAccount;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		try {
			bankAccount.writersSemaphore.acquire();
			bankAccount.writers++;
			if(bankAccount.writers == 1)
				bankAccount.readersWaitingSemaphore.acquire();
			bankAccount.writersSemaphore.release();
			
			bankAccount.balanceSemaphore.acquire();
			System.out.println("Write started");

			Thread.currentThread().sleep(2000);
			System.out.println("WriterTask: "+bankAccount.getBalance()+" + "+amount);
			bankAccount.deposit(amount);
			System.out.println("Write finished\n");
			Thread.currentThread().sleep(4000);
			
			bankAccount.balanceSemaphore.release();
			
			bankAccount.writersSemaphore.acquire();
			bankAccount.writers--;
			if(bankAccount.writers == 0)
				bankAccount.readersWaitingSemaphore.release();
			bankAccount.writersSemaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
