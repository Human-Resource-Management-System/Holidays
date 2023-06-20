package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import models.JobGrade;

@Repository
public class JobGradeDAOImpl implements JobGradeDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public JobGrade getJobGradeById(String jbgrId) {
        return entityManager.find(JobGrade.class, jbgrId);
    }
}
