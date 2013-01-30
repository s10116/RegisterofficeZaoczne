package registerOffice.businessObjects.films;

import javax.persistence.Entity;

@Entity
public class BluRay extends Film{

	@Override
	public String getFilmDetails() {
		return "This is a BluRay.";
	}
	
	private String HD;
	private String title;
	private String serialNumber;

	public String getHD() {
		return HD;
	}

	public void setHD(String HD) {
		this.HD = HD;
	}
	
	
	//konstruktory
		public BluRay(String title, String serialNumber, String HD)
		{
			this.setTitle(title);
			this.setSerialNumber(serialNumber);
			this.HD = HD;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}
	
	
	
	
/*
	@Override
	public Film Clone() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}

