package registerOffice.businessObjects.films;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
//import registerOffice.Context;
import registerOffice.businessObjects.clients.Klient;


@Entity
public abstract class Film implements FilmInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Klient owner; //owner alias wew klasy

/*
	@Transient //adnotacja
	Context context;
	public Film(){
		context =Context.getInstance();  //licznik obiektów w pamięci
		context.raiseNumberOfCars();
	}
*/
	
	public void printData()
	{
		System.out.println("Owner: "+owner.getName());
		System.out.println(getFilmDetails()); //getCarDetails
	}
	
	public abstract String getFilmDetails();
	
	//public abstract Film Clone();
	
	public void setOwner(Klient owner)
	{
		this.owner=owner;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*
	@Override
	protected void finalize() throws Throwable {
		context.reduceFilms();
		super.finalize();
	}
*/
	
}
