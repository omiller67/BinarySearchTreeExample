import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TreeDriver {
	
	private Tree myTree;
	
	public TreeDriver() {
		try {
			treeInitializer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Tree treeInitializer() throws FileNotFoundException {
		 this.myTree = new Tree();

	     Scanner fileScanner = new Scanner(new File("words.txt"));
	     while (fileScanner.hasNext()) {
	         myTree.addNode(fileScanner.next());
	     }
	     System.out.println("Filling tree from words.txt...");
	     System.out.println();
	     return myTree;
	 }
	 
	 private int userChoice() {
		 
	     int userChoice = 0;
	     Scanner in = new Scanner(System.in);
	     boolean invalidNumber = false;
	     do {
	    	 try {
	    		 if(invalidNumber) {
	    			 System.out.println("Please enter a number between 1 and 5");
	    		 }
	    		 System.out.println("1. Check the tree for a specific word");
	    	     System.out.println("2. Check if the tree is empty");
	    	     System.out.println("3. Get the size of the tree");
	    	     System.out.println("4. Get the height of the tree");
	    	     System.out.println("5. Check if the tree is balanced");
	    	     userChoice = in.nextInt();
	    	     if(userChoice < 1 || userChoice > 5) {
	    	    	 invalidNumber = true;
	    	     }
	    	 } catch (InputMismatchException e) {
	    		 System.out.println("Please enter a number between 1 and 5");
	    	 }
	    	 in.nextLine();
	     } while(userChoice < 1 || userChoice > 5);
	     
	     return userChoice;
	 }
	 
	 private void checkForWord() {
		 String searchWord;
		 System.out.print("Search: ");
		 Scanner in = new Scanner(System.in);
		 searchWord = in.nextLine();
		 System.out.println(myTree.checkTree(searchWord));
	 }
	 
	 private void checkEmpty() {
		 System.out.println(myTree.isEmpty());
	 }
	 
	 private void checkSize() {
		 System.out.println(myTree.getSize());
	 }
	 
	 private void checkHeight() {
		 System.out.println(myTree.getHeight());
	 }
	 
	 private void checkBalance() {
		 System.out.println(myTree.isBalanced());
	 }
	 
	 private void TreeAction(int choice) {
		 switch(choice) {
		 	case 1: checkForWord();
		 			break;
		 	case 2: checkEmpty();
		 			break;
		 	case 3: checkSize();
		 			break;
		 	case 4: checkHeight();
		 			break;
		 	case 5: checkBalance();
		 			break;
		 }
	 }
	 
	 private void start() {
		
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			int action = userChoice();
			TreeAction(action);
			System.out.println("Would you like to do something else (Y/N)?");
			String userResponse = in.nextLine();
			if(userResponse.equalsIgnoreCase("n")) {
				done = true;
				System.out.println("See you later!");
			}
			
		}
		
	 }
	public static void main(String[] args) {
		TreeDriver driver = new TreeDriver();
		driver.start();
	}

}
