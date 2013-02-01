package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
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
import registerOffice.management.conditions.Condition;
//import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Klient> hib= 
				new HibernatePersonManager(session);
				
		
		//DVD
		Klient flem = new Klient("Flem kowalski", "80121212123456", "Mila 11");
		Film td = new DVD("Ted","2013TD");
		flem.getFilms().add(td);
		td.setOwner(flem);
		hib.save(flem);
		
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
		
		
		
//		ManagerInterface<Person> mgr= new HsqlPersonManager();
//		
////		ManagerInterface<Person> mgr= new PersonManager();
////		
//		mgr.save(new Person("Adam","1234","Gdańsk"));
//		mgr.save(new Person("Paweł","12345","Elbląg"));
//		mgr.save(new Person("Michał","12344","Gdańsk"));
//		mgr.save(new Person("Ola","1234534","Gdynia"));
//		mgr.save(new Person("Ania","1236544","Sopot"));
//		mgr.save(new Person("Adam","12342","Sopot"));
//		mgr.save(new Person("Adam","12344","Gdańsk"));
//		mgr.save(new Person("Adam","12354","Gdynia"));
////		
//		for(Person p: mgr.getAll())
//			System.out.println(p.getName());
//		
//		Condition<Person> byname=new GetByNameCondition("Adam");
//		Condition<Person> byaddress=new GetByAddressCondition("Sopot");
//		Condition<Person> mainCondition=new Condition<Person>()
//				{
//					@Override
//					protected boolean check(Person obj) {
//						return true;
//					}};
//		
//		byname.setCondition(byaddress);
//		mainCondition.setCondition(byname);
//		for(Person p:mgr.getAll(mainCondition))
//		{
//			System.out.println(p.getName()
//					+" "
//					+p.getAddress()
//					+" "+ p.getPesel());
//		}
//		
	}

}
