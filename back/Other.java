package back;
import java.util.Scanner;

public class Other {
	
	public static void useMachine(VendingMachine vm) {
		boolean use=true;
		Scanner s=new Scanner(System.in);
		System.out.println("Dzieñ dobry!");
		while(use) {
			int action;
			System.out.println("________________________");
			System.out.println("Wybierz porz¹dan¹ akcjê:\n1 - zakup produktu\n2 - prace serwisowe\n3 - wyjœcie");
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
				System.out.println("B³êdna akcja!");
			}
		}
		System.out.println("Do widzenia!");
	}

}
