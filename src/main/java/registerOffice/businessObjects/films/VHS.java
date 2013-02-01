package registerOffice.businessObjects.films;

import javax.persistence.Entity;

@Entity
public class VHS extends Film{

	@Override
	public String getFilmDetails() {
		return "This is a VHS.";
	}
	
	private String Rew;
	private String title;
	private String serialNumber;


	
	//konstruktory
		public VHS(String title, String serialNumber, String Rew)
		{
			this.setTitle(title);
			this.setSerialNumber(serialNumber);
			this.Rew = Rew;
		}

	//wlasciwosci
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
	
		public String getRew() {
			return Rew;
		}

		public void setRew(String Rew) {
			this.Rew = Rew;
		}
		

}

