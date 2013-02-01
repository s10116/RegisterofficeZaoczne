package registerOffice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.clients.*;
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
import registerOffice.businessObjects.films.*;

public class Main {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Klient> hib= 
				new HibernatePersonManager(session);
				
		
		
		//DVD
		Klient jan_kow = new Klient("Jan Kowalski", "80121212123456", "Mila 11");
		Film td = new DVD("Ted","2013TD");
		jan_kow.getFilms().add(td);
		td.setOwner(jan_kow);
		hib.save(jan_kow);
		
		//BluRay
		Klient earl = new Klient("Earl", "81111111111346", "Dobra 22");
		Film sw = new BluRay("Star","2012SW", "HD"); // yes to HD
		earl.getFilms().add(sw);
		sw.setOwner(earl);
		hib.save(earl); 
				
		//VHS
		Klient bob = new Klient("rl", "811346", "Dupa 45");
		Film pupa = new VHS("pupa","2012pup", "yes");
		bob.getFilms().add(pupa);
		pupa.setOwner(bob);
		hib.save(bob); 
		
		
		
		
		List<Klient>results = hib.getAll();
		
		for(Klient p :results)
		{
			System.out.println(p.getName());
		}
		
	
		
	}

}
