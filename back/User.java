package back;
import java.util.Scanner;

public class User {
	
	protected static int getProductNr(Scanner s) {
		int number;
		System.out.println("Podaj numer produktu ");
		number=s.nextInt();
		if(number<0) return -1;
		else return number;
	}
	
	protected static int getPaymentMethod(Scanner s) {
		int number;
		System.out.println("Wybierz sposób zap³aty:\n1 - gotówka\n2 - karta ");
		number=s.nextInt();
		if(number!=1 && number!=2) return -1;
		else return number;
	}
	
	protected static boolean doCashPayment(Scanner s, MoneyBox mb, double price) {
		double amount;
		System.out.println("Do zap³aty "+price+"z³\nW³ó¿ monety...");
		amount=s.nextDouble();
		double change=amount-price;
		if(change<0) {
			System.out.println("Zbyt ma³a kwota!");
			return false;
		}
		else {
			mb.add(price);
			System.out.println("Wydano resztê: "+change+"z³");
			return true;
		}
		
	}
	
	protected static boolean doCardPayment(CardReader cr, double price) {
		System.out.println("Do zap³aty "+price+"z³");
		if(!cr.hasConnection()) {
			System.out.println("Brak po³¹czenia...");
			cr.fixConnection();
			System.out.println("Nawi¹zano po³¹czenie");
		}
		System.out.println("Zbi¿ kartê");
		System.out.println("...");
		System.out.println("Transakcja zakoñczona");
		return true;
	}
	
	

}
