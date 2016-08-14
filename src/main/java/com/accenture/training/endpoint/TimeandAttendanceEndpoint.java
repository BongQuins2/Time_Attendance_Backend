package com.accenture.training.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.training.Constants;
import com.accenture.training.data.EmpShift;
import com.accenture.training.data.Employee;
import com.accenture.training.data.Login;
import com.accenture.training.data.Shift;
import com.accenture.training.data.TimeTracker;
import com.accenture.training.data.ViewEmpShift;
import com.accenture.training.data.ViewLoginInfo;
import com.accenture.training.data.ViewTimeTracker;
import com.accenture.training.data.repository.EmpShiftViewRepository;
import com.accenture.training.data.repository.EmployeeRepository;
import com.accenture.training.data.repository.LoginViewRepository;
import com.accenture.training.data.repository.ShiftRepository;
import com.accenture.training.data.repository.TimeTrackViewRepository;
import com.accenture.training.data.repository.TimeTrackerRepository;
import com.accenture.training.service.TimeandAttendanceService;

@RestController
public class TimeandAttendanceEndpoint {

	@Autowired
	private TimeandAttendanceService timeandAttendanceService;

	@Autowired
	TimeTrackViewRepository timeTrackerViewRepository;

	@Autowired
	EmpShiftViewRepository empShiftViewRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ShiftRepository shiftRepository;

	@Autowired
	TimeTrackerRepository timetrackerRepository;
	
	@Autowired
	LoginViewRepository loginViewRepository;

	// -------------------

//	@RequestMapping(value = "/checkusername", method = RequestMethod.POST)
//	public Login checkUser(@RequestParam("user_name") String username) {
//		Login login = timeandAttendanceService.findUsername(username);
//		return login;
//	}
	@RequestMapping(value = Constants.CHECKUSERNAMEPASSWORD, method = RequestMethod.POST)
	public int checkUser(@RequestParam(Constants.USERNAME) String username,
			@RequestParam(Constants.USERPASSWORD) String password) {
		int exist = timeandAttendanceService.checkUsernamePassword(username,
				password);
		return exist;
	}

    @RequestMapping(value = Constants.LOGIN_COUNTUSERNAME,
            method = RequestMethod.GET)
	public int findUser(@RequestParam(Constants.USERNAME) String username) {
    	int exist = timeandAttendanceService.findUsername(username);    
		return exist;
    }
    
    @RequestMapping(value = Constants.LOGIN_SAVE,
            method = RequestMethod.POST)
	public void registerUser(@RequestParam String username, 
			@RequestParam String password) {
    	timeandAttendanceService.registerLogin(username, password);
    }
    
    
    @RequestMapping(value = Constants.LOGIN_VIEWALL,
            method = RequestMethod.GET)
	public List<ViewLoginInfo> viewAllLogin() {
    	return loginViewRepository.findAll();
    }

    @RequestMapping(value = Constants.LOGIN_UPDATE,
            method = RequestMethod.POST)
	public void updateLoginPassword(@RequestParam int userId, @RequestParam String user_password) {
    	timeandAttendanceService.saveUpdateLoginPassword(userId, user_password);
    }
    
    @RequestMapping(value = Constants.LOGIN_REMOVE,
            method = RequestMethod.POST)
    @Transactional
	public void removeLogin(@RequestParam int userId) {
    	timeandAttendanceService.deleteLogin(userId);
    }


//	@RequestMapping(value = "/getusername", method = RequestMethod.GET)
//	public Login findUser(@RequestParam("user_name") String username) {
//		Login login = timeandAttendanceService.findUsername(username);
//		return login;
//	}

//	@RequestMapping(value = "/login/save", method = RequestMethod.POST)
//	public void registerUser(@RequestBody Login loginTable) {
//		timeandAttendanceService.registerLogin(loginTable);
//	}

	// -------------------

	@RequestMapping(value = "/employee/get", method = RequestMethod.GET)
	public Employee findEmployee(@RequestParam("emp_id") int empId) {
		Employee emp = timeandAttendanceService.findEmployee(empId);
		return emp;
	}

//	@RequestMapping(value = "/employee/getempid", method = RequestMethod.GET)
//	public int findEmpId(@RequestParam("emp_username") String emp_username) {
//		int emp = timeandAttendanceService.findEmpId(emp_username);
//		return emp;
//	}
	
	// @CrossOrigin(origins="http://localhost:8000")
	@RequestMapping(value = Constants.EMPLOYEE_VIEWALL, method = RequestMethod.GET)
	public List<Employee> viewAllEmployee() {
		return employeeRepository.findAll();
	}

	@RequestMapping(value = Constants.EMPLOYEE_SAVE, method = RequestMethod.POST)
	public void registerNewEmployee(@RequestParam String emp_username,
			@RequestParam String emp_fullname, @RequestParam int emp_level) {
		timeandAttendanceService.saveNewEmployee(emp_username, emp_fullname,
				emp_level);
	}

	@RequestMapping(value = Constants.EMPLOYEE_UPDATE, method = RequestMethod.POST)
	public void registerEditEmployee(@RequestParam int empId,
			@RequestParam String emp_username,
			@RequestParam String emp_fullname, @RequestParam int emp_level) {
		timeandAttendanceService.saveUpdateEmployee(empId, emp_username,
				emp_fullname, emp_level);
	}

	@RequestMapping(value = Constants.EMPLOYEE_REMOVE, method = RequestMethod.POST)
	@Transactional
	public void removeEmployee(@RequestParam int empId) {
		timeandAttendanceService.deleteEmployee(empId);
	}

	@RequestMapping(value = "/empshift/get", method = RequestMethod.GET)
	public EmpShift findEmpShift(@RequestParam("emp_shift_id") int empShiftId) {
		EmpShift es = timeandAttendanceService.findEmpShift(empShiftId);
		return es;
	}

	@RequestMapping(value = Constants.EMPSHIFT_SAVE, method = RequestMethod.POST)
	public void registerNewEmpShift(@RequestParam int empId,
			@RequestParam int shiftId) {
		timeandAttendanceService.saveEmpShift(empId, shiftId);
	}

	@RequestMapping(value = Constants.EMPSHIFT_UPDATE, method = RequestMethod.POST)
	public void registerEditEmpShift(@RequestParam int empShiftId,
			@RequestParam int shiftId) {
		timeandAttendanceService.saveUpdateEmpShift(empShiftId, shiftId);
	}

	@RequestMapping(value = Constants.EMPSHIFT_REMOVE, method = RequestMethod.POST)
	@Transactional
	public void removeEmpShift(@RequestParam int empShiftId) {
		timeandAttendanceService.deleteEmpShift(empShiftId);
	}

	@RequestMapping(value = Constants.EMPSHIFT_VIEWALL, method = RequestMethod.GET)
	public List<ViewEmpShift> viewAllEmpShift() {
		return empShiftViewRepository.findAll();
	}

	@RequestMapping(value = "/empshift/viewByEmployee", method = RequestMethod.GET)
	public List<ViewEmpShift> viewByEmp(@RequestParam int empId) {
		return empShiftViewRepository.findByempId(empId);
	}

//	@RequestMapping(value = "/shift/get", method = RequestMethod.GET)
//	public Shift findShift(@RequestParam("shift_id") int shift_id) {
//		Shift shft = timeandAttendanceService.findShift(shift_id);
//		return shft;
//	}

	@RequestMapping(value = Constants.SHIFT_VIEWALL, method = RequestMethod.GET)
	public List<Shift> viewAllShift() {
		return shiftRepository.findAll();
	}

	@RequestMapping(value = Constants.SHIFT_SAVE, method = RequestMethod.POST)
	public void registerShift(@RequestParam String shift_start,
			@RequestParam String shift_end, @RequestParam String shift_break,
			@RequestParam String shift_name) {
		timeandAttendanceService.saveNewShift(shift_start, shift_end,
				shift_break, shift_name);
		// Shift shift =
		// timeandAttendanceService.saveShift(shift_start,shift_end,shift_break,shift_name);
		// return shift;
	}

	@RequestMapping(value = Constants.SHIFT_UPDATE, method = RequestMethod.POST)
	public void registerShift(@RequestParam int shiftId,
			@RequestParam String shift_start, @RequestParam String shift_end,
			@RequestParam String shift_break, @RequestParam String shift_name) {
		timeandAttendanceService.saveUpdateShift(shiftId, shift_start,
				shift_end, shift_break, shift_name);
		// Shift shift =
		// timeandAttendanceService.saveShift(shift_start,shift_end,shift_break,shift_name);
		// return shift;
	}

	@RequestMapping(value = Constants.SHIFT_REMOVE, method = RequestMethod.POST)
	@Transactional
	public void removeShift(@RequestParam int shiftId) {
		timeandAttendanceService.deleteShift(shiftId);
	}

	@RequestMapping(value = Constants.TIMETRACKER_VIEWALL, method = RequestMethod.GET)
	public List<ViewTimeTracker> viewAllTimeTracker() {
		return timeTrackerViewRepository.findAll();
	}

	@RequestMapping(value = Constants.TIMETRACKER_VIEWBYEMPLOYEE, method = RequestMethod.GET)
	public List<ViewTimeTracker> viewTimeTracker(@RequestParam int empId) {
		return timeTrackerViewRepository.findByempId(empId);
	}

	@RequestMapping(value = Constants.TIMETRACKER_VIEWBYEMPDATE, method = RequestMethod.GET)
	public List<ViewTimeTracker> viewTimeTrackerByEmpDate(
			@RequestParam int empId, @RequestParam String tt_date) {
		return timeTrackerViewRepository.displayByEmpDateAttendance(empId,
				tt_date);
	}

	//modified
	@RequestMapping(value = Constants.TIMETRACKER_SAVE, method = RequestMethod.POST)
	@Transactional
	public int registertimeTracker(@RequestParam int empId,@RequestParam String tt_date){
		int status = 0;
		status = timeandAttendanceService.saveTimeTracker(empId,tt_date);
		return status;
	}

	@RequestMapping(value = Constants.TIMETRACKER_REMOVE, method = RequestMethod.POST)
	@Transactional
	public void removeTimeTracker(@RequestParam("tt_id") int ttId) {
		timeandAttendanceService.deleteTimeTracker(ttId);
	}

	// added
	@RequestMapping(value = Constants.USER_TIMETRACKER, method = RequestMethod.GET)
	@Transactional
	public List<ViewTimeTracker> getTimetrackerByEmpId(
			@RequestParam(Constants.EMP_ID) int empId) {
		return timeandAttendanceService.getTimetrackerByEmpId(empId);
	}

	@RequestMapping(value = Constants.EMPLOYEE_GETEMPID, method = RequestMethod.GET)
	public int findEmpId(@RequestParam(Constants.EMP_USERNAME) String emp_username) {
		int emp = timeandAttendanceService.findEmpId(emp_username);
		return emp;
	}
	
	@RequestMapping(value = Constants.FIND_TIMETRACKER, method = RequestMethod.POST)
	public int findTimeTrackerTimeInOut(
			@RequestParam(Constants.EMPID) int empId,
			@RequestParam(Constants.TT_DATE) String tt_date) {
		int TimeIn = 0;
		TimeIn = timeandAttendanceService.findTimetrackerTimeIn(empId,tt_date);
		return TimeIn;
	}
	

}
