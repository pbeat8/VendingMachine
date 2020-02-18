package back;

public class Maintenance {
	
	protected static void addProduct(ProduceBox pb) {
		System.out.println(pb.getProdName()+" - Stan przed nape³nieniem: "+pb.getContaining());
		pb.fillUp();
		System.out.println("Stan po nape³nieniu: "+pb.getContaining());
	}
	
	protected static void addMoney(MoneyBox pb) {
		System.out.println("Stan przed nape³nieniem: "+pb.getContaining());
		pb.fillUp();
		System.out.println("Stan po nape³nieniu: "+pb.getContaining());
	}
	
	protected static void emptyOutMoney(MoneyBox mb) {
		System.out.println("Stan przed opró¿nieniem: "+mb.getContaining());
		mb.emptyOut();
		System.out.println("Stan po opró¿nieniu: "+mb.getContaining());
	}

}
