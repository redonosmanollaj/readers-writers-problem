package first_solution;


public class ReaderTask implements Runnable{
	private BankAccount bankAccount;
	
	public ReaderTask(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		try {
			bankAccount.readersSemaphore.acquire();
			bankAccount.readers++;
			
			if(bankAccount.readers == 1)
				bankAccount.semaphore.acquire();
			
			bankAccount.readersSemaphore.release();
			
			System.out.println("Read started");
			Thread.currentThread().sleep(2000);
			System.out.println("ReaderTask: Balance is "+bankAccount.getBalance());
			System.out.println("Read finished\n");
			
			bankAccount.readersSemaphore.acquire();
			
			bankAccount.readers--;

			if(bankAccount.readers == 0)
				bankAccount.semaphore.release();
			
			bankAccount.readersSemaphore.release();
					
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
