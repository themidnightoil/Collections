import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String args[]){
		
		WordCounter wc = null;
		try {
			wc = new WordCounter("C:\\Users\\HP Phoenix\\workspace\\Collections2\\src\\TheRaven.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		System.out.println("***************Program Counts all the words in text file***********");
		
		System.out.print( "Enter number 1 for alphebetically sorted word Count\n"
						 +"Enter number 2 for numerically sorted word Count\n"
						 +"Enter number 3 for unsorted word Count");
				
			
		while(true){
			System.out.print("Please Enter A number: ");
			try{
				 option = scan.nextInt();
				int[] possibleNumbers = {1,2,3};
				for(int x : possibleNumbers){
					if(x == option){
						switch (option){
						
						case 1:
							System.out.println("******Alphebetical Sort******");
							wc.alphabeticalSort();
							break;
						case 2:
							System.out.println("*********Numerical Sort*******");
							wc.numericalSort();
							break;
						case 3:
							System.out.println("********Unsorted*******");
							wc.regularPrint();
							break;
						}
					}
				}
				continue;
				
				
			}catch(InputMismatchException e){
				System.out.println("Only enter numbers 1-3 ");
				break;
			}
		}
				

				
	
				
				
	
	
	
		
	}
}
