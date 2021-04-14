package bankPackage;

import java.util.*;

public class Bank {
	
	private static int maxAccount = 3;
	private static int startAccount = 0;
	private static int nextAccount = 0;
	
	public static void main(String[] args)
	{
		CurrentAccount[] acc = new CurrentAccount[maxAccount];
		
		/* Rule */
		System.out.println("<---------------------------------->");
		System.out.println("Selamat Datang Di Bank Sejahtera");
		System.out.println("<---------------------------------->");
		System.out.println("1. Kamu hanya bisa buat akun " + maxAccount + " kali saja");
		System.out.println("2. Kamu bisa menghapus akun, tetapi tidak membuat kamu bisa melebihi batas pembuatan akun");
		System.out.println("3. Setiap kamu memilih sesuatu, maka dianggap 1 bulan berlalu dan saldo mu akan mendapat bunga");
		System.out.println("4. Saldo kamu gak boleh minus lebih dari overdraft limit / melakukan withdraw yang menyebabkan keadaan tersebut");
		System.out.println("5. Bunga harus berada 0% < bunga < 100%, jika tidak default bunga = 10 %\n\n");
		
		/* Bank Application */
		boolean isExit = false;
		Scanner scan = new Scanner(System.in);
		while(!isExit)
		{
			System.out.println("Kamu Layanan Apa ?");
			System.out.println("----------------------------------\n");
			System.out.println("1. Buat Akun");
			System.out.println("2. Hapus Akun");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Print Info");
			System.out.println("6. Keluar\n\n");
			
			System.out.print("Pilihan mu : ");
			int choice = scan.nextInt();
			switch(choice)
			{
				case 1 :
					if(nextAccount < maxAccount)
					{
						/*Input Info*/
						System.out.print("Besar Bunga (%): ");
						int interest = scan.nextInt();
						System.out.print("Batas overdraft : ");
						int overdraftLimit = scan.nextInt();
						
						// set default jika input tidak dalamr range
						if(interest <= 0 || interest > 100)
							interest = 10;
						
						/* Create Account */
						acc[nextAccount++] = new CurrentAccount(nextAccount, interest, overdraftLimit);
						System.out.println("Account Succesfully Created\n");
					}else
						System.out.println("Cannot create more account, your account is full!\n");  
					break;
					
				case 2 :
					/*Delete akun jika tidak kosong*/
					if(startAccount < nextAccount)
					{
						startAccount++;
						System.out.println("Account Succesfully Deleted\n");
					}
					else
						System.err.println("Cannot delete more account, your account is empty!\n"); 
					break;
				
				case 3 :
					/* Deposit */
					if(startAccount < nextAccount)
					{
						System.out.println("Kamu mau deposit akun yang mana ?");
						System.out.println("1. Semua Akun");
						System.out.println("2. Akun tertentu");
						System.out.print("Pilihan mu : ");
						int depositChoice = scan.nextInt();
						switch(depositChoice)
						{
							case 1 : 
								// Lakukan Deposit semua akun
								System.out.print("Masukan Besar Deposit Setiap Akun: ");
								double amounts = scan.nextDouble();
								Deposit(acc, amounts);
								break;
							case 2 :
								// Lakukan Deposit di satu akun tertentu
								System.out.println("Ketikan nomor akun mu : ");
								int accountNumber = scan.nextInt() - 1;
								System.out.print("Masukan Besar Deposit Setiap Akun: ");
								double amount = scan.nextDouble();
								if(accountNumber >= startAccount && accountNumber < nextAccount)
									Deposit(acc[accountNumber], amount);
								break;
						}
					}else
						System.err.println("Anda Tidak memiliki akun untuk di deposit\n");
					break;
				
				case 4 :
					if(startAccount < nextAccount)
					{
						System.out.println("Kamu mau withdraw akun yang mana ?");
						System.out.println("1. Semua Akun");
						System.out.println("2. Akun tertentu");
						System.out.print("Pilihan mu : ");
						int withdrawChoice = scan.nextInt();
						switch(withdrawChoice)
						{
						case 1 : 
							// Lakukan withdraw semua akun
							System.out.print("Masukan Besar Withdraw Setiap Akun: ");
							double amounts = scan.nextDouble();
							Withdraw(acc, amounts);
							break;
						case 2 :
							// Lakukan withdraw di satu akun tertentu
							System.out.println("Ketikan nomor akun mu : ");
							int accountNumber = scan.nextInt() - 1;
							System.out.print("Masukan Besar Withdraw Akun: ");
							double amount = scan.nextDouble();
							if(accountNumber >= startAccount && accountNumber < nextAccount)
								Withdraw(acc[accountNumber], amount);
							break;
						}
					}else
						System.err.println("Anda Tidak memiliki akun untuk di withdraw\n");
					break;
					
				case 5 :
					/*Print semua info akun kamu*/
					if(startAccount < nextAccount)
						Print(acc);
					else
						System.err.println("Anda Tidak memiliki akun");
					break;
					
				case 6 :
					/*Selesai Layanan*/
					isExit = true;
					break;
			}
			
			// update akun
			Update(acc);
		}
		scan.close();
		System.out.println("\nTerima kasih telah berkunjung!\n");
	}
	
	/* Update an account */
	public static void Update(CurrentAccount[] acc)
	{
		/* Adding interest to balance */
		for(int i = 0; i < nextAccount; i++) { acc[i].AddInterest(); }
		
		/* Check if an account is in overdraft status */
		System.out.println("\nOverdraft account Status : ");
		for(int i = 0; i < nextAccount; i++)
		{
			if(acc[i].isOverdraft())
				System.out.println("the account number " + (int)acc[i].getAccountNumber() + " is in overdraft status!\n");
		}
	}
	
	/* Deposit to account*/
	public static void Deposit(CurrentAccount[] acc, double aDeposit)
	{
		for(int i = 0; i < nextAccount; i++)
		{
			acc[i].deposit(aDeposit);
		}
			
	}
	
	public static void Deposit(CurrentAccount acc, double aDeposit)
	{
		
		acc.deposit(aDeposit);
	}
	
	/* Deposit from account*/
	public static void Withdraw(CurrentAccount[] acc, double aWithdraw)
	{
		for(int i = 0; i < nextAccount; i++)
			acc[i].Withdraw(aWithdraw);
	}
	
	public static void Withdraw(CurrentAccount acc, double aWithdraw)
	{
		acc.Withdraw(aWithdraw);
	}
	
	
	/* Print info of an account */
	public static void Print(CurrentAccount[] acc)
	{
		for(int i = 0; i < nextAccount; i++)
			acc[i].print();
		System.out.println("\n");
	}
	
	public static void Print(CurrentAccount acc)
	{
		acc.print();
		System.out.println("\n");
	}

}
