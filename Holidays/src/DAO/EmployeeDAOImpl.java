package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import models.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
    
    @Override
    public Employee getEmployeeById(int emplId) {
        return entityManager.find(Employee.class, emplId);
    }
    
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}
