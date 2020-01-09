package third_solution;


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
			bankAccount.queueSemaphore.acquire();
			
			bankAccount.balanceSemaphore.acquire();
			
			bankAccount.queueSemaphore.release();
			
			System.out.println("Write started");
			Thread.currentThread().sleep(2000);
			System.out.println("WriterTask: "+bankAccount.getBalance()+" + "+amount);
			bankAccount.deposit(amount);
			System.out.println("Write finished\n");
			
			Thread.currentThread().sleep(4000);
			
			bankAccount.balanceSemaphore.release();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

