package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO implements JpaDAO {
    private final EntityManagerFactory EntityManagerFactory= Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager EntityManager = EntityManagerFactory.createEntityManager();
    private List<Employee> list=null;
    public void Save(Employee employee){
        EntityManager.getTransaction().begin();
        EntityManager.persist(employee);
        EntityManager.getTransaction().commit();

    }
    public void Upadate(Employee employee){
        EntityManager.getTransaction().begin();
        EntityManager.persist(employee);
        EntityManager.getTransaction().commit();
    }
    public List<Employee> GetList(){
        TypedQuery<Employee> query= EntityManager.createQuery("SELECT a FROM Student a",Employee.class);
        this.list= query.getResultList();
        return list;
    }
    public void Delete (Employee employee){
        EntityManager.getTransaction().begin();
        EntityManager.remove(employee);
        EntityManager.getTransaction().commit();
    }
    public void close (){
        EntityManager.close();
    }
}
