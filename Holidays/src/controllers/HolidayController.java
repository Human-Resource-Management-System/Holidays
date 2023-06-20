package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.HolidayDAO;
import models.Holiday;

@Controller
public class HolidayController {

	private final HolidayDAO hd;

	@Autowired
	public HolidayController(HolidayDAO holidayDAO) {
		this.hd = holidayDAO;

	}

	@RequestMapping("/holidays")
	public String showHolidayss() {
		return "index2";
	}

	@RequestMapping("/holidaysupd")

	public String showHolidays(Model model) {
		List<Holiday> holidays = hd.findAllHolidays();

		model.addAttribute("holidays", holidays);

		return "holidays";
	}

	@RequestMapping("/admindashboard")
	public String showAdmin() {
		return "Index_admin";
	}

	/*----------------------------------------------*/
	@RequestMapping(value = "/getattend")
	public String getAttend(Model model) {
		return "attend";
	}

	@RequestMapping(value = "/getallempattend")
	public String getAllEmpAttend(Model model) {
		return "adattend";
	}

	@RequestMapping(value = "/offer", method = RequestMethod.GET)
	public String getOffer(Model model) {
		return "offer";
	}

	@RequestMapping(value = "/leaveupdate")
	public String handleLogin2() {
		return "leaveupd";
	}

	@RequestMapping(value = "/leavedelete")
	public String handleLogin3() {
		return "leavedel";
	}

	@RequestMapping(value = "/leaves")
	public String getLeaves(Model model) {

		return "viewleave";
	}

	@RequestMapping(value = "/permissionapply")
	public String getPermission(Model model) {

		return "permissionform";
	}

	@RequestMapping(value = "/permissions")
	public String viewPermission(Model model) {

		return "viewpermissions";
	}

	@RequestMapping(value = "/adshowleaves")
	public String adviewleave(Model model) {

		return "adshowleaves";
	}

	@RequestMapping(value = "/adshowpermission")
	public String adviewpermission(Model model) {

		return "adshowpermission";
	}

	@RequestMapping(value = "/adapproval")
	public String adApproval(Model model) {

		return "adapproval";
	}

	@RequestMapping(value = "/empapproval")
	public String empApproval(Model model) {

		return "empapproval";
	}

	@RequestMapping("/employees")
	public String showEmployees(Model model) {
		// List<Object[]> employees = emp.getAllEmployees();
		// model.addAttribute("employees", employees);
		return "employees";
	}

	@RequestMapping(value = "/addempl")
	public String addEmpl(Model model) {

		return "addempl";
	}

	@RequestMapping(value = "/delempl")
	public String delEmpl(Model model) {

		return "delempl";
	}

	@RequestMapping(value = "/candidate")
	public String showCandidateForm() {
		return "candidate";
	}

	@RequestMapping(value = "/candidateview")
	public String getCandidates(Model model) {

		return "viewcandidate";
	}

	@RequestMapping(value = "/induction")
	public String showInductionForm() {
		return "induction";
	}

	@RequestMapping(value = "/inductionview")
	public String getInduction(Model model) {

		return "viewinduction";
	}

	@RequestMapping(value = "/empholidays")
	public String getEmpHolidays(Model model) {
		return "emphol";
	}

	@RequestMapping(value = "/empleaves")
	public String getEmpLeaves(Model model) {
		return "emplev";
	}

	@RequestMapping(value = "/adhollev")
	public String getAD(Model model) {
		return "emphollev";
	}

}
