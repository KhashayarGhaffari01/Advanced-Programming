package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;

public abstract class BaseManager<E,S extends Serializable> {

    private final SessionFactory sessionFactory = buildSessionFactory();
    private SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    protected abstract Class<E> getEntityClass();
    public S save(E o){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        S s = (S) session.save(o);
        session.getTransaction().commit();
        session.close();
        return s;
    }
    public void update(E o){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }
    public E fetch(S s){
        Session session = sessionFactory.openSession();
        E e = session.get(getEntityClass(),s);
        session.close();
        return e;
    }
}
