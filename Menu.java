package myPackage;

import java.util.*;
import java.io.IOException;
import java.io.File;


public class Menu {
	Scanner sc = new Scanner(System.in);
	Operations optns = new Operations();

    static String Path;
    File folder_Name;

	public void  Menu01() {
		Path = System.getProperty("user.dir");
		folder_Name = new File(Path + "/files");
		if (!folder_Name.exists())
			folder_Name.mkdirs();
		System.out.println("Directory Workspace: " + folder_Name.getAbsolutePath());
	}	
	
	public void WelcomeScreen() {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("   **   LOCKED IN WELCOMES YOU  **   ");
		System.out.println("   ** Devloped By Aditya Gulhane**   ");
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("\n\n");
	}

	public void exitScreen() {
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("      ** Thankyou For Visiting **    ");
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
	}
	public void  mainMenu() {
		System.out.println("--------------------------------------");
		System.out.println(" Select The Following Options\n  ");
		System.out.println("1. List of Sorted Files in Directory\n");
		System.out.println("2. Tasks and Operations\n ");
		System.out.println("3. EXIT THE PROGRAM\n");
		System.out.println("-------------------------------------");
		System.out.println("Enter your INPUT: ");
	}
	public void OPERATIONS_Tasks() {
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("1. ADD A FIle");
		System.out.println("2. DELETE A FIlE");
		System.out.println("3. SEARCH A File");
		System.out.println("4. GO BACK TO MAIN MENU");
		System.out.println("-------------------------------------");
		System.out.println("ENTER YOUR CHOICE:  ");
	}
	public void mainMENU() {
		int choice = 0;
		int decision = 0;
		do {
			
			mainMenu();

			try {
				choice = Integer.parseInt(sc.nextLine());
			    }
			catch(NullPointerException e){
				System.out.println("\n INVALID INPUT TRY: (1-3)\n");
				mainMENU();
				}
			switch (choice) {

			case 1:

				System.out.println();
				try {
					optns.listAllFiles(Main.Path);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("\n******************************");
				break;


			case 2:
				System.out.println();
				OPERATIONS_Tasks();
				break;

			case 3:
				System.out.println("\n ARE YOU SURE YOU WANT TO EXIT? \n Y/N");
				System.out.println(" [Y = YESS]  [N = NO] ");
				System.out.println("-------------------------------------");
				decision = sc.nextLine().toUpperCase().charAt(0);
				if (decision == 'Y' ) {
					System.out.println("\n");exitScreen();
					System.exit(1);  
				}
				else if(decision == 'N') {
					System.out.println("\n");
					mainMENU();	
				}
			default:

				System.out.println("INVALID INPUT ---- SELECT(1-3)\n");
				mainMENU();
		}
	}while(true);
	}
		public void Operations_Tasks() {
			String file = null;
			String FileName = null;
			int choice = 0;
			
			do { 
				OPERATIONS_Tasks();
				
				try {
					choice = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e) {
					System.out.println("INVALID INPUT PLEASE SELECT: (1-4)");
					Operations_Tasks();
				}
				
				switch (choice) {
				
				case 1:
					    System.out.println("\n");
					    System.out.println("ADD A FILE---->>>");
					    System.out.println("ENTer a File NAme---->>>");
					    file = sc.nextLine();
					    try {
					    	optns.createNewFile(Main.Path, FileName);
					    }
					    catch (IOException e){
					    	System.out.println("ERROR WHILE ADDING\n");
					    	System.out.println("PLEASE TRY AGAIN");
					    }
					    catch(Exception e) {
					    	System.out.println("ERROR WHILE ADDING\n");
					    	System.out.println("PLEASE TRY AGAIN");
					    }
					    System.out.println("\n");
					    System.out.println("---------------------------");
					    break;
					    
				case 2:
					
					System.out.println("\n");
					System.out.println("DELETE A FILE\n");
					System.out.println(" Enter a File Name to Delete---->> ");
					file = sc.nextLine();
					FileName = file.trim();
					
					try {
						optns.deleteFile(Main.Path, FileName);
					}
					catch(NullPointerException e){
						System.out.println(e.getMessage());
					}
					catch(IOException e) {
						System.out.println("Error while Deleting\n");
						System.out.println("PLease Try Again...");
					}
					catch(Exception e) {
						System.out.println("Error while Deleting\n");
						System.out.println("PLease Try Again...");
					}
					System.out.println("--------------------------------");
					break;
				case 3:
					
					System.out.println("\n");
					System.out.println("Search a File\n");
					System.out.println("Please Enter a file Name to proceed--->>");
					file = sc.nextLine();
					FileName = file.trim();
					try {
						optns.SearchFile(Main.Path, FileName);
					}
					catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}
					catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("-----------------------------------------");
					break;
				case 4:mainMenu();
				       break;
				       
				 default:
					 System.out.println("INVALID INPUT PLEASE SELECT(1-4)");				
					    }
				file = null;
				FileName = null;
					    
				
			}while(true);
						
			
	}
		

	}





