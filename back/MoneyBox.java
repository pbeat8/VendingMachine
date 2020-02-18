package back;

//Standardowo w MoneyBox powinno si� znajdowa� 1/2 * size monet.
//fillUp dodaje do containing do tej ilo�ci
//emptyOut odejmuje z containing do tej ilo�ci
public class MoneyBox implements Box{

	private final double size;
	private double containing;
	
	public MoneyBox(double s) {
		size=s;
		containing=0;
	}
	@Override
	public boolean isEmpty() {
		return containing==0;
	}

	@Override
	public void fillUp() {
		double deficit=size/2-containing;
		if(deficit>0) containing=size/2;
	}

	public double emptyOut() {
		double excess=containing-size/2;
		if(excess>0) {
			containing=size/2;
			return excess;
		}
		else return 0;
	}
	
	@Override
	public boolean take() {
		return false;
	}
	
	public void add(double amount) {
		double excess=amount+containing-size;
		if(excess>=0) {
			System.out.println("Automat wymaga opr�nienia!");
			System.out.println("Zwrot: "+excess);
			containing=size;
		}
		else containing+=amount;
	}
		
	public double getSize() {
		return size;
	}
	
	public double getContaining() {
		return containing;
	}
	

}
