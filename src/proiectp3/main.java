package proiectp3;

import java.util.Scanner;

public class main {
	public static void Creare_legitimatie() {
		String nume1 = null,prenume1 = null,cnp = null;
		int an=0;
		Scanner inputInt =new Scanner(System.in);
		Scanner inputString =new Scanner(System.in);
		System.out.println("Introduceti-va numele:");
		inputString.next(nume1);
		System.out.println("Introduceti-va prenumele:");
		inputString.next(prenume1);
		System.out.println("Introduceti-va cnp-ul:");
		inputString.next(cnp);
		System.out.println("Introduceti-va varsta");
		inputInt.nextInt(an);
		Legitimatie l = new Legitimatie(nume1,prenume1,an,cnp);
		
		
	}

	public static void main(String[] args) {
		
		gui incercare =new gui();
		int a=2;
		
	}

}
