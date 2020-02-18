package back;
import java.util.Scanner;

public class Other {
	
	public static void useMachine(VendingMachine vm) {
		boolean use=true;
		Scanner s=new Scanner(System.in);
		System.out.println("Dzie� dobry!");
		while(use) {
			int action;
			System.out.println("________________________");
			System.out.println("Wybierz porz�dan� akcj�:\n1 - zakup produktu\n2 - prace serwisowe\n3 - wyj�cie");
			action=s.nextInt();
			switch(action) {
			case 1:
				vm.showProducts();
				vm.clientTransaction(s);
				break;
			case 2:
				vm.maintenanceTasks(s);
				break;
			case 3:
				use=false;
				break;
			default:
				System.out.println("B��dna akcja!");
			}
		}
		System.out.println("Do widzenia!");
	}

}
