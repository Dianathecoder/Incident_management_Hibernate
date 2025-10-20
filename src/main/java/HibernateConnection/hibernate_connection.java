
package HibernateConnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author cmdia
 */
public class hibernate_connection {
    
public static final SessionFactory sessionFactory;
static{
    try{
        Configuration config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
        
    }catch(Exception e){
        System.out.println("Se produjo un error al conectar"+e.getMessage());
        throw new ExceptionInInitializerError(e);
    }
}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


   
  
}


