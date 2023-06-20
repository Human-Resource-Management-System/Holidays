package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import models.JobGradeLeaves;

@Repository
public class JobGradeLeavesDAOImpl implements JobGradeLeavesDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public JobGradeLeaves getJobGradeLeavesByGrade(String jbgrId) {
        return entityManager.find(JobGradeLeaves.class, jbgrId);
    }
}
