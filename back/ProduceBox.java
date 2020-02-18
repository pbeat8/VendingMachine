package back;

public class ProduceBox implements Box{

	private final String prodName;
	private final double price;
	private final int size;
	private int containing;
	
	public ProduceBox(String name, double p, int s) {
		prodName=name;
		price=p;
		size=s;
		containing=0;
	}

	@Override
	public boolean isEmpty() {
		return containing==0;
	}

	@Override
	public void fillUp() {
		if(size-containing!=0) containing=size;
	}

	@Override
	public boolean take() {
		if(isEmpty()) return false;
		else {
			containing--;
			return true;
		}
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public double getPrice() {
		return price;
	}

	public int getSize() {
		return size;
	}

	public int getContaining() {
		return containing;
	}


}
