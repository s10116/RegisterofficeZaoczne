package registerOffice.management.conditions;

import registerOffice.businessObjects.clients.Klient;

public class GetByNameCondition extends Condition<Klient>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Klient obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
