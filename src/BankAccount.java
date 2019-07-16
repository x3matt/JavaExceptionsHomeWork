
public class BankAccount {

	private String IBAN;

	public BankAccount(String iBAN) {
		super();
		IBAN = iBAN;
	}

	public String getIBAN() {
		return IBAN;
	}

	@Override
	public String toString() {
		return "[IBAN=" + IBAN + "]";
	}
	
}
