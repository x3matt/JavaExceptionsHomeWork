import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BankAccount b1 = new BankAccount("DE17649259274610");
		
		BankAccount b2 = new BankAccount("IT17649259274610");
		BankAccount b3 = new BankAccount("TI1764925927");
		
		BankAccount b4 = new BankAccount("DE17649259282734");
		BankAccount b5 = new BankAccount("DE17649127352649");
		
		Customer c1 = new Customer("Ivan",17,b1);
		Customer c2 = new Customer("Andrey",16,b4);
		Customer c3 = new Customer("Anton",22,b2);
		Customer c4 = new Customer("Denis",11,b3);
		Customer c5 = new Customer("Egor",10,b5);
		List<Customer> input = Arrays.asList(c1,c2,c3,c4,c5);
		checker(input);
	}
	public static void checker(List<Customer> input) 
			throws Exception{
			checkAge(input);
			checkLength(input);
			checkTwoFirstSymbols(input);
      }	
	
	public static void checkAge(List<Customer> input) {
		for (int i = 0; i < input.size(); i++) {
			try {
				if(input.get(i).getAge() <17) {
					throw new InvalidAgeException("Invalid age: "+input.get(i).getAge());
				}
			}catch(InvalidAgeException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	public static void checkLength(List<Customer> input) 
			throws Exception{
		for (int i = 0; i < input.size(); i++) {
			try {
				if(input.get(i)
						.getAccount()
						.getIBAN()
						.length()<16 ||input.get(i)
						.getAccount()
						.getIBAN()
						.length()>16) {
					throw new InvalidLengthException("Invalid length: "+input.get(i)
					.getAccount()
					.getIBAN()
					.length());
				}
			}catch(InvalidLengthException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public static void checkTwoFirstSymbols(List<Customer> input) 
			throws Exception{
		for (int i = 0; i < input.size(); i++) {
			try {
				if(!input.get(i).getAccount().getIBAN().substring(0,2).equals("DE")) {
					throw new InvalidTwoFirstSymbolsException("Invalid two first symbols: "+input.get(i)
					.getAccount()
					.getIBAN()
					.substring(0,2));
				}
			}catch(InvalidTwoFirstSymbolsException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
   }