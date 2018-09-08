package service.MVC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.MVC.HibernateUtil;
import model.MVC.UserBean;
import model.MVC.UserBean;

public class RegisterService {
	
	public boolean register(UserBean user){
		// create session factory
		
				Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserBean.class);
				// create session
				
				SessionFactory sf = con.buildSessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
				session.save(user);
				tx.commit();
				
				System.out.println(user);
		return true;
	}
}

