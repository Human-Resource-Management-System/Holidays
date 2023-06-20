package controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.EmployeeDAO;
import DAO.EmployeeOptedLeavesDAO;
import DAO.HolidayDAO;
import DAO.JobGradeHolidaysDAO;
import models.Employee;
import models.EmployeeOptedLeaves;
import models.EmployeeOptedLeavesId;
import models.Holiday;
import models.JobGradeHolidays;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private HolidayDAO holidayDAO;

	@Autowired
	private JobGradeHolidaysDAO jobGradeHolidaysDAO;

	@Autowired
	private EmployeeOptedLeavesDAO employeeOptedLeavesDAO;

	@Autowired
	private ApplicationContext context;

	public void setJobGradeHolidaysDAO(JobGradeHolidaysDAO jobGradeHolidaysDAO) {
		// Set the jobGradeHolidaysDAO property
		this.jobGradeHolidaysDAO = jobGradeHolidaysDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void setHolidayDAO(HolidayDAO holidayDAO) {
		this.holidayDAO = holidayDAO;
	}

	@GetMapping("/employee/{emplId}")
	public String displayEmployeeInformation(@PathVariable int emplId, Model model) {
		Employee employee = employeeDAO.getEmployeeById(emplId);
		if (employee != null) {
			JobGradeHolidays jobGradeHolidays = jobGradeHolidaysDAO
					.getJobGradeHolidaysByGrade(employee.getEmplJbgrId());
			List<Holiday> holidays = holidayDAO.findAlloptedHolidays();
			int mandholidays = holidayDAO.countMandHolidays();

			// Calculate remaining holidays

			model.addAttribute("employee", employee);
			model.addAttribute("jobGradeHolidays", jobGradeHolidays);

			model.addAttribute("holidays", holidays);
			model.addAttribute("mandholidays", mandholidays);

			return "employee-information";
		} else {
			// Handle case when employee is not found
			throw new EmployeeNotFoundException("Employee not found with ID: " + emplId);
		}
	}

	// Other controller methods

	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFoundException(EmployeeNotFoundException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "error-page";
	}

	// Other methods

	public void setEmployeeOptedLeavesDAO(EmployeeOptedLeavesDAO employeeOptedLeavesDAO) {
		this.employeeOptedLeavesDAO = employeeOptedLeavesDAO;
	}

	@RequestMapping(value = "/employee/submit", method = RequestMethod.GET)
	@Transactional
	public String submitSelectedHolidays(@RequestParam("selectedHolidays") List<String> selectedHolidays,
			@RequestParam("emplId") int emplId) {
		// Process the selected holidays and save to the database
		System.out.println("hello this is emplId " + emplId);
		List<String> years = new ArrayList<>();
		List<String> dates = new ArrayList<>();

		for (String holiday : selectedHolidays) {
			String[] parts = holiday.split("\\|");
			// years.add(parts[0]);
			// dates.add(parts[1]);

			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

			try {
				LocalDate localDate = LocalDate.parse(parts[1].trim(), inputFormatter);
				Date date = Date.valueOf(localDate);
				System.out.println(date);

				EmployeeOptedLeavesId employeeoptedleavesId = context.getBean(EmployeeOptedLeavesId.class);

				employeeoptedleavesId.setEmployeeId(emplId);
				employeeoptedleavesId.setHolidayDate(date);

				EmployeeOptedLeaves employeeoptedleaves = context.getBean(EmployeeOptedLeaves.class);

				employeeoptedleaves.setOptedleavesId(employeeoptedleavesId);
				employeeoptedleaves.setYear_id(Integer.parseInt(parts[0].trim()));

				employeeOptedLeavesDAO.saveEmployeeOptedLeaves(employeeoptedleaves);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/success";
	}
}