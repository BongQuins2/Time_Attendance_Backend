package com.accenture.training.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.data.EmpShift;
import com.accenture.training.data.Employee;
import com.accenture.training.data.Login;
import com.accenture.training.data.Shift;
import com.accenture.training.data.TimeTracker;
import com.accenture.training.data.ViewTimeTracker;
import com.accenture.training.data.repository.EmpShiftRepository;
import com.accenture.training.data.repository.EmployeeRepository;
import com.accenture.training.data.repository.LoginRepository;
import com.accenture.training.data.repository.ShiftRepository;
import com.accenture.training.data.repository.TimeTrackViewRepository;
import com.accenture.training.data.repository.TimeTrackerRepository;

@Service
public class TimeandAttendanceService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ShiftRepository shiftRepository;

	@Autowired
	private TimeTrackerRepository timeTrackerRepository;

	@Autowired
	private EmpShiftRepository empShiftRepository;

	@Autowired
	private TimeTrackViewRepository timeTrackerViewRepository;

	@Autowired
	private LoginRepository loginRepository;

	// -------------------
//	public Login findUsername(String username) {
//		Login login = loginRepository.findByUsername(username);
//		return login;
//	}
    public int findUsername(String username) {
    	int exist = loginRepository.countByName(username);    
		return exist;
    }

	public int checkUsernamePassword(String username, String password) {
		// 0 = username does not exist
		// 1 = username exist
		// 2 = username/password valid
		// 3 = password invalid
		int exist = loginRepository.countByName(username);
		if (exist == 1) { // username exist
			exist = 0; // initialize
			exist = loginRepository.checkByNamePassword(username, password);
			if (exist == 1) {
				exist = 2; // password match
			} else {
				exist = 3; // password invalid/don't match
			}
		} else {
			exist = 0; // username invalid/don't exist
		}
		return exist;
	}

//	public void registerLogin(Login loginTable) {
//		Login login = new Login();
//		login.setUserId(loginRepository.maxByuserID() + 1);
//		login.setUsername(loginTable.getUsername());
//		login.setUser_password(loginTable.getUser_password());
//		loginRepository.save(login);
//	}
	
    public void saveUpdateLoginPassword(int userId, String user_password) {
    	Login login = loginRepository.findByUserId(userId);
    	login.setUser_password(user_password);
    	loginRepository.save(login);
    }

	public void deleteLogin(int userId) {
		loginRepository.deleteByUserId(userId);    
    }	

	// -------------------

	public Employee findEmployee(int empid) {
		Employee emp = employeeRepository.findByEmpId(empid);
		return emp;
	}

	public void saveNewEmployee(String emp_username, String emp_fullname,
			int emp_level) {
		Employee employee = new Employee();
		employee.setEmpId(employeeRepository.maxByEmployeeID() + 1);
		employee.setEmp_username(emp_username);
		employee.setEmp_fullname(emp_fullname);
		employee.setEmp_level(emp_level);
		employeeRepository.save(employee);
	}

	public void saveUpdateEmployee(int empId, String emp_username,
			String emp_fullname, int emp_level) {
		Employee employee = employeeRepository.findByEmpId(empId);
		employee.setEmp_username(emp_username);
		employee.setEmp_fullname(emp_fullname);
		employee.setEmp_level(emp_level);
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int empId) {
		employeeRepository.deleteByempId(empId);
	}

	public Shift findShift(int shift_id) {
		Shift shft = shiftRepository.findByShiftId(shift_id);
		return shft;
	}

	public void saveNewShift(String shift_start, String shift_end,
			String shift_break, String shift_name) {
		Shift shift = new Shift();
		shift.setShift_id(shiftRepository.maxByShiftID() + 1);
		shift.setShift_start(shift_start);
		shift.setShift_end(shift_end);
		shift.setShift_break(shift_break);
		shift.setShift_name(shift_name);
		shiftRepository.save(shift);
	}

	public void saveUpdateShift(int shiftId, String shift_start,
			String shift_end, String shift_break, String shift_name) {
		Shift shift = shiftRepository.findByShiftId(shiftId);
		shift.setShift_start(shift_start);
		shift.setShift_end(shift_end);
		shift.setShift_break(shift_break);
		shift.setShift_name(shift_name);
		shiftRepository.save(shift);
	}

	public void deleteShift(int shiftId) {
		shiftRepository.deleteByShiftId(shiftId);
	}

	//modified
	public int saveTimeTracker(int empId, String tt_date){
		//0 - initial value
		//1 - save time in
		//2 - save time out
		int status =0;
		Employee emp = employeeRepository.findByEmpId(empId);
		String ttTimeIn = timeTrackerRepository.displayTimeIn(emp, tt_date);
		TimeTracker timeTracker = new TimeTracker();
		if (ttTimeIn == null) {
			timeTracker.setTt_id(timeTrackerRepository.maxByTimeTrackerID() + 1);
			timeTracker.setTt_date(tt_date);
			timeTracker.setEmp_id(emp);
			timeTracker.setTime_in(DateTime.now().toString("MM/dd/yyyy HH:mm"));
			timeTrackerRepository.save(timeTracker);
			status = 1;
		} else {
			timeTrackerRepository.updateTimeTrackerByEmpIdttDate(DateTime.now().toString("MM/dd/yyyy HH:mm"), emp, tt_date);
			status = 2;
		}

		return status;
	}

	public void deleteTimeTracker(int ttId) {
		timeTrackerRepository.deleteByttId(ttId);
	}

	public EmpShift findEmpShift(int empShiftId) {
		EmpShift es = empShiftRepository.findByEmpShiftId(empShiftId);
		return es;
	}

	public void saveEmpShift(int empId, int shiftId) {
		Employee emp = employeeRepository.findByEmpId(empId);
		Shift shift = shiftRepository.findByShiftId(shiftId);
		EmpShift empShift = new EmpShift();
		empShift.setEmpShiftId(empShiftRepository.maxByEmpShiftID() + 1);
		empShift.setShift_id(shift);
		empShift.setEmp_id(emp);
		empShiftRepository.save(empShift);
	}

	public void saveUpdateEmpShift(int empShiftId, int shiftId) {
		EmpShift empShift = empShiftRepository.findByEmpShiftId(empShiftId);
		Shift shift = shiftRepository.findByShiftId(shiftId);
		empShift.setShift_id(shift);
		empShiftRepository.save(empShift);
	}

	public void deleteEmpShift(int empShiftId) {
		empShiftRepository.deleteByempShiftId(empShiftId);
	}

	// added
	public List<ViewTimeTracker> getTimetrackerByEmpId(int empId) {
		return timeTrackerViewRepository.displayByEmpIdAttendance(empId);
	}

	public int findEmpId(String emp_username) {
		int emp = employeeRepository.findByEmpUsername(emp_username);
		return emp;
	}
	
	public int findTimetrackerTimeIn(int empId, String tt_date){
		int status = 0;
		String TimeIn = "";
		TimeIn = timeTrackerViewRepository.findTimeInByEmpidTTdate(empId, tt_date);
		if(TimeIn != null){
			status = 1;
		}else{
			status = 0;
		}
		return status;
	}
	
    public void registerLogin(String username, String password) {
        Login login = new Login();
        login.setUserId(loginRepository.maxByuserID()+1);
        login.setUsername(username);
        login.setUser_password(password);
        loginRepository.save(login);
    }


}
