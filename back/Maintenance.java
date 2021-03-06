package back;

public class Maintenance {
	
	protected static void addProduct(ProduceBox pb) {
		System.out.println(pb.getProdName()+" - Stan przed napełnieniem: "+pb.getContaining());
		pb.fillUp();
		System.out.println("Stan po napełnieniu: "+pb.getContaining());
	}
	
	protected static void addMoney(MoneyBox pb) {
		System.out.println("Stan przed napełnieniem: "+pb.getContaining());
		pb.fillUp();
		System.out.println("Stan po napełnieniu: "+pb.getContaining());
	}
	
	protected static void emptyOutMoney(MoneyBox mb) {
		System.out.println("Stan przed opróżnieniem: "+mb.getContaining());
		mb.emptyOut();
		System.out.println("Stan po opróżnieniu: "+mb.getContaining());
	}

}
