package registerOffice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import registerOffice.businessObjects.clients.*;
//import registerOffice.businessObjects.films.*; //dubel
import registerOffice.businessObjects.films.BluRay;
import registerOffice.businessObjects.films.DVD;
import registerOffice.businessObjects.films.Film;
import registerOffice.businessObjects.films.VHS;
import registerOffice.management.*;
/*niezaimplementowane
import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import registerOffice.management.conditions.Condition; 
import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;
*/


public class Main {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Klient> hib= 
				new HibernatePersonManager(session);
				
		
		
		//tworzenie klientow       // ('imie nazwisko','pesel', 'ulica')
		Klient jan_kow = new Klient("Jan Kowalski", "79010123456", "Mila 11");
		Klient mar_now = new Klient("Marek Nowak", "80020225256", "Szara 22");
		Klient ste_bob = new Klient("Stefan Bobowski", "81030314266", "Ciepla 33");
		Klient ann_kwi = new Klient("Anna Kwiat", "82040431426", "Dobra 44");
		Klient paw_fle = new Klient("Pawel Flemowski", "83050531789", "Zla 55");
		Klient ola_mal = new Klient("Ola Mala", "84060631790", "Zupa 66");
		Klient mir_wie = new Klient("Mirek Wielki", "85070731790", "Danie 77");
		
		
		
		//dodawanie DVD   // ('nazwa filmu','sygnatura filmu')
		Film TD = new DVD("Ted","2012TD"); 
		Film AePr = new DVD("Absolute Power","1997AePr");
		Film Un = new DVD("Unforgiven","1992Un");
		
		
		//dodawanie BluRay  // ('nazwa filmu','sygnatura filmu', 'informacja o HD')
		Film SrWs = new BluRay("Star Wars","2011SrWs", "HD"); // say yes to HD
		Film GnTo = new BluRay("Gran Torino","2008GnTo", "HD");
		Film TeUlSs = new BluRay("The Usual Suspects","1995TeUlSs", "HD");
		
		
		//dodawanie VHS     // ('nazwa filmu','sygnatura filmu', 'informacja czy przewinieto film')
		Film DyHy = new VHS("Dirty Harry","1971DyHy", "yes"); 
		Film MmFe = new VHS("Magnum Force","1973MmFe", "no"); 
		Film TeRe = new VHS("The Rookie","1990TeRe", "yes");
		
				
		//przypisanie klienta do filmu
		TD.setOwner(jan_kow);
		SrWs.setOwner(mar_now);
		DyHy.setOwner(ste_bob);
		MmFe.setOwner(ste_bob);
		GnTo.setOwner(ann_kwi);
		AePr.setOwner(paw_fle);
		TeRe.setOwner(ste_bob);
		Un.setOwner(ola_mal);
		TeUlSs.setOwner(mir_wie);
		
		
		//przypisywanie filmu do klienta
		jan_kow.getFilms().add(TD);
		mar_now.getFilms().add(SrWs);
		ste_bob.getFilms().add(DyHy);
		ste_bob.getFilms().add(MmFe);
		ann_kwi.getFilms().add(GnTo);
		paw_fle.getFilms().add(AePr);
		ste_bob.getFilms().add(TeRe);
		ola_mal.getFilms().add(Un);
		mir_wie.getFilms().add(TeUlSs);
		
		
		//zapisanie danych klientow
		hib.save(jan_kow);
		hib.save(mar_now); 
		hib.save(ste_bob); 
		hib.save(ann_kwi);
		hib.save(paw_fle);
		hib.save(ola_mal);
		hib.save(mir_wie);
	
		
		List<Klient>results = hib.getAll();
		
		for(Klient p :results)
		{
			System.out.println(p.getName());
		}
		
	
		
	}

}
