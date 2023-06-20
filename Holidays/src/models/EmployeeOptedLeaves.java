package models;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "hrms_employeeoptedleaves")
public class EmployeeOptedLeaves {
    @Id
    @Column(name = "eolv_date")
    private Date eolvDate;

    @ManyToOne
    @JoinColumn(name = "empl_id")
    private Employee employee;

    @Column(name = "year_id")
    private int yearId;

    // Constructors, getters, and setters

    public EmployeeOptedLeaves() {
    }

    public EmployeeOptedLeaves(Date eolvDate, Employee employee, int yearId) {
        this.eolvDate = eolvDate;
        this.employee = employee;
        this.yearId = yearId;
    }

    public Date getEolvDate() {
        return eolvDate;
    }

    public void setEolvDate(Date eolvDate) {
        this.eolvDate = eolvDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }
}
