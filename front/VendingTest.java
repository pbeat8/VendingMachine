package front;
import back.VendingMachine;
import back.Other;

public class VendingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VendingMachine myVM=new VendingMachine(4,20);
		myVM.testInitialize();
		Other.useMachine(myVM);

	}

}
