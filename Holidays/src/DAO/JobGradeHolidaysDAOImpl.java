package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import models.JobGradeHolidays;

@Repository
public class JobGradeHolidaysDAOImpl implements JobGradeHolidaysDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public JobGradeHolidays getJobGradeHolidaysByGrade(String jbgrId) {
        return entityManager.find(JobGradeHolidays.class, jbgrId);
    }
}
