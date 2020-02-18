package back;

public class CardReader {
	
	private boolean connection;
	
	public CardReader() {
		connection=false;
	}

	public boolean fixConnection() {
		if(connection) return false;
		else {
			connection=true;
			return true;
		}
	}
	
	public boolean hasConnection() {
		return connection;
	}	

}
