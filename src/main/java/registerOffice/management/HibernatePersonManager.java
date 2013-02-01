
//pobiera klientow z bazy i ich obsluguje
package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.clients.Klient;

public class HibernatePersonManager 
	implements ManagerInterface<Klient>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Klient get(int id) {
		
		List<Klient> result = 
				session.getNamedQuery("Klient.id")
					.setInteger("id", id).list();
		if(result.size()==0)
			return null;
		
		Klient returnValue = new Klient(
				result.get(0).getName(), 
				result.get(0).getPesel(),
				result.get(0).getAddress());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Klient> getAll() {
		List<Klient> result =
				session.getNamedQuery("Klient.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Klient obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Klient obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Klient.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
