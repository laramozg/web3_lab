package db;

import model.Hit;
import javax.ejb.Singleton;
import javax.persistence.*;
import java.util.List;
@Singleton
public class HitsDatabaseManager {

    private final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hits");

    public List<Hit> getHitsData() {
        EntityManager manager = managerFactory.createEntityManager();
        List<Hit> hits = null;
        try {
            TypedQuery<Hit> query = manager.createQuery("SELECT hits FROM Hit hits", Hit.class);
            hits = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return hits;
    }

    public void insert(Hit hit) {
        EntityManager manager = managerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(hit); //todo откат транзакции
            manager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void clear() {
        EntityManager manager = managerFactory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.createQuery("delete from Hit hits", Hit.class).executeUpdate();
            manager.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }
}
