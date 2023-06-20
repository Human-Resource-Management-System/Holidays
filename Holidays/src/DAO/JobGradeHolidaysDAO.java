package DAO;

import models.JobGradeHolidays;

public interface JobGradeHolidaysDAO {
    JobGradeHolidays getJobGradeHolidaysByGrade(String jbgrId);
}

