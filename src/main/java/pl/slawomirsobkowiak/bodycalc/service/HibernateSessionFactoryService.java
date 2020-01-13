package pl.slawomirsobkowiak.bodycalc.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class HibernateSessionFactoryService {
    public SessionFactory sessionFactory;
    public HibernateSessionFactoryService() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }
}
