import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





public class Number_Ring_Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Number_Ring test1 = new Number_Ring();
		
		boolean running = true;
		Scanner keys = new Scanner(System.in);
		Scanner ringlist = new Scanner(new FileReader("COSC489_PT_2168_Input.txt"));
		ArrayList<Integer> ringnumbers = new ArrayList<Integer>();
		
		while(ringlist.hasNextInt())
		{
			ringnumbers.add(ringlist.nextInt());
			
		}
		Collections.reverse(ringnumbers);
		for(int x = 0; x<= ringnumbers.size()-1 ; x++)
		{
			test1.Insert(ringnumbers.get(x));
		}
		
		
		while(running == true)
		{
			System.out.println("Please choose an operation, enter 0 to exit");
			System.out.println("1 : insert");
			System.out.println("2 : append");
			System.out.println("3 : delete");
			System.out.println("4 : jump");
			System.out.println("5 : sort");
			System.out.println("6 : print");
			
			int a = Integer.parseInt(keys.nextLine());
			if(a == 0)
			{
				System.out.println("Exiting");
				running = false;
			}
			else if(a == 1)
			{
				System.out.println("Insert : ");
				 a = Integer.parseInt(keys.nextLine());
				 test1.Insert(a);
			}
			else if(a == 2)
			{
				System.out.println("Append : ");
				 a = Integer.parseInt(keys.nextLine());
				 test1.Append(a);
			}
			else if(a == 3)
			{
				System.out.println("Deleting");
        test1.Delete();
			}
			else if(a == 4)
			{
				System.out.println("Jump : ");
				 a = Integer.parseInt(keys.nextLine());
				 test1.Jump(a);
			}
			else if(a == 5)
			{
				System.out.println("Sorting");
				test1.Sort();
				 
			}
			else if(a == 6)
			{
				test1.Print();
			}
			else
			{
				System.out.println("Error, try again");
			}
			
		}
		
		
		

	}

}
