package back;

import java.util.ArrayList;
import java.util.Scanner;


public class VendingMachine {
	
	private ArrayList<ProduceBox> products;
	private MoneyBox money;
	private CardReader card;
	
	public VendingMachine(int prod, double m) {
		products=new ArrayList<ProduceBox>(prod);
		money=new MoneyBox(m);
		card=new CardReader();
	}
	
	protected void showProducts() {
		for(int i=0; i<products.size(); i++) {
			System.out.println(i+": "+products.get(i).getProdName()+"\n\tCena: "+products.get(i).getPrice()+"z³");
			System.out.println("\tSztuk:  "+products.get(i).getContaining());
		}
	}
	
	protected void showMoney() {
		System.out.println("Iloœæ pieniêdzy w automacie: "+money.getContaining());
		System.out.println("Pojemnoœæ automatu: "+money.getSize());
		System.out.print("Stan terminala: ");
		if(!card.hasConnection()) System.out.print("nie ");
		System.out.println("pod³¹czony do sieci");
	}
	
	protected void clientTransaction(Scanner s) {
		int pnumber=User.getProductNr(s);
		if(pnumber==-1 || pnumber>products.size() || products.get(pnumber).isEmpty()) {
			if(pnumber==-1 || pnumber>products.size())  System.out.println("B³êdny numer produktu");
			else System.out.println("Brak wybranego produktu");
		}
		
		else {
			int paymethod=User.getPaymentMethod(s);
			if(paymethod==-1) System.out.println("B³êdna metoda p³atnoœci");
			else {
				boolean success;
				if(paymethod==1) {
					success=User.doCashPayment(s, money, products.get(pnumber).getPrice());
				}
				else {
					success=User.doCardPayment(card, products.get(pnumber).getPrice());
				}
				if(success) {
					if(products.get(pnumber).take()) System.out.println("Wydajê "+products.get(pnumber).getProdName()+"\nDziêkujemy :)");
					else System.out.println("Coœ posz³o nie tak :(");
				}
			}
		}
	}
	
	protected void maintenanceTasks(Scanner s) {
		int action;
		System.out.println("Wybierz operacjê");
		System.out.println("1 - dodaj wszytkie produkty\n2 - dodaj monety\n3 - wyjmij monety\n4 - poka¿ stan urz¹dzenia\n5 - powrót");
		action=s.nextInt();
		switch(action) {
		case 1:
			for(ProduceBox pb: products) Maintenance.addProduct(pb);
			break;
		case 2:
			 Maintenance.addMoney(money);
			break;
		case 3:
			Maintenance.emptyOutMoney(money);
			break;
		case 4:
			showProducts();
			showMoney();
			break;
		default:
			System.out.println("B³êdna operacja");
		}
	}
	
	public void testInitialize() {
		products.add(new ProduceBox("Woda",2.0,5));
		products.add(new ProduceBox("Baton",2.5,5));
		products.add(new ProduceBox("Cola",2.5,5));
		products.add(new ProduceBox("Paluszki",3.0,5));
	}
	
	

}
