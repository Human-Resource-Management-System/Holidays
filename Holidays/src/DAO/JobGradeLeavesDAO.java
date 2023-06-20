package DAO;

import models.JobGradeLeaves;

public interface JobGradeLeavesDAO {
    JobGradeLeaves getJobGradeLeavesByGrade(String jbgrId);
}
