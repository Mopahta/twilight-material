package by.bsuir.Kaminsky.tools.ConsoleReader;

import java.util.Scanner;

public class ConsoleReader {	
	
	private static Scanner in = new Scanner(System.in);
	
	public static Boolean getBoolean()	{
		while (!in.hasNextBoolean())  {
			in.next();
		}
		return in.nextBoolean();
	}
	
	public static Boolean getAnswer() {
		char answer;
		do {
			answer = in.nextLine().toLowerCase().charAt(0);
		} while (answer != 'y' && answer != 'n');
		if (answer == 'y')
			return true;
		else {
			return false;
		}
	}
	
	public static void fflush() {
		in.nextLine();
	}
		
	public static String getString() {
		return in.nextLine();
	}	
}

