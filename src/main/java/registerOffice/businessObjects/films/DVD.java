package registerOffice.businessObjects.films;
import javax.persistence.Entity;

@Entity
public class DVD extends Film{

	
	private String title;
	private String serialNumber;
	
	//konstruktory
	public DVD(String title, String serialNumber)
	{
		this.title=title;
		this.serialNumber=serialNumber;
	}
/*	
	public DVD()
	{
		this("","");
	}
*/	
	//wlasciwosci
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getserialNumber() {
		return serialNumber;
	}

	public void setserialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	//metody
	

	@Override
	public String getFilmDetails() {
		return title+" "+serialNumber;
	}
/*
	@Override
	public Film Clone() { 
		
		DVD returnValue =new DVD();
		returnValue.setserialNumber(this.serialNumber);
		
		return returnValue;
	}
*/	
}
