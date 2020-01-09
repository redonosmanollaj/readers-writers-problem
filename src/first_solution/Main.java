package first_solution;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("FIRST SOLUTION - Readers Preference");
		final double BALANCE = 200;
		
		BankAccount bankAccount = new BankAccount(BALANCE);
		
		ReaderTask reader = new ReaderTask(bankAccount);
		WriterTask writer = new WriterTask(bankAccount,20);
		
		Thread tReader1 = new Thread(reader);
		Thread tReader2 = new Thread(reader);
		Thread tReader3 = new Thread(reader);

		Thread tWriter1 = new Thread(writer);
		Thread tWriter2 = new Thread(writer);
		Thread tWriter3 = new Thread(writer);
		
		
		
//		tReader1.start();
//		tWriter1.start();
//		tWriter2.start();
//		tReader2.start();
//		tWriter3.start();
//		tReader3.start();
		
		while(true) {
			Thread tReader = new Thread(reader);
			Thread tWriter = new Thread(writer);
			tReader.start();
			tWriter.start();
		}
		
	}
}
