package registerOffice.management.conditions;

import registerOffice.businessObjects.clients.Klient;

public class GetByPeselCondition extends Condition<Klient>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Klient obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
