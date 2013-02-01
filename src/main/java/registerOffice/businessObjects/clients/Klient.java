package registerOffice.businessObjects.clients;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

//import registerOffice.Context;
import registerOffice.businessObjects.films.*;


@Entity //encja robi z tego tabelę
@Table(name = "Klient") // Osoby
@NamedQueries({
	@NamedQuery(
			name="Klient.all",
			query="from Klient p"
			),
	@NamedQuery(
			name="Klient.id",
			query="from Klient p where id= :id"
			),
	@NamedQuery(
			name="Klient.delete",
			query="Delete from Klient p where id=:id"
			)
})
public class Klient {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Imie_Nazwisko")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Film> films;
	
	private String pesel;
	private String address;
	
	//@Transient
	//Context context;
	
	/*
	public Klient(String name, String pesel, String address) // do importu z import.sql
	{
		this(name,pesel);
		this.address=address;
	}
	*/
	
	public Klient(String name, String pesel, String address) //public Klient(String name, String pesel)
	{
	//	context= Context.getInstance();
	//	context.raisenumberOfPeople();
		this.name=name;
		this.address=address; // było puste
		this.pesel=pesel;
		this.films=new ArrayList<Film>();
	}
/*	
	public Klient(String name) {
		
		this(name,"");
	}
	
	public Klient()
	{
		
		this("","");
	}
*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Film> getFilms() { 
		return films;
	}
	public void setfilms(List<Film> films) {
		this.films = films;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
	//	context.reducePeople();
		super.finalize();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
