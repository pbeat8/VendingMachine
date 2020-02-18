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
		System.out.println("Wybierz spos�b zap�aty:\n1 - got�wka\n2 - karta ");
		number=s.nextInt();
		if(number!=1 && number!=2) return -1;
		else return number;
	}
	
	protected static boolean doCashPayment(Scanner s, MoneyBox mb, double price) {
		double amount;
		System.out.println("Do zap�aty "+price+"z�\nW�� monety...");
		amount=s.nextDouble();
		double change=amount-price;
		if(change<0) {
			System.out.println("Zbyt ma�a kwota!");
			return false;
		}
		else {
			mb.add(price);
			System.out.println("Wydano reszt�: "+change+"z�");
			return true;
		}
		
	}
	
	protected static boolean doCardPayment(CardReader cr, double price) {
		System.out.println("Do zap�aty "+price+"z�");
		if(!cr.hasConnection()) {
			System.out.println("Brak po��czenia...");
			cr.fixConnection();
			System.out.println("Nawi�zano po��czenie");
		}
		System.out.println("Zbi� kart�");
		System.out.println("...");
		System.out.println("Transakcja zako�czona");
		return true;
	}
	
	

}
