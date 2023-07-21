package milkteaorder.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import milkteaorder.controller.shipper.dto.WorkDayDto;
import milkteaorder.jwt.JwtTokenUtil;
import milkteaorder.model.Staff;
import milkteaorder.model.StaffWorkDay;
import milkteaorder.model.StaffWorkDayKey;
import milkteaorder.model.WorkDay;
import milkteaorder.repository.StaffRepository;
import milkteaorder.repository.StaffWorkDayRepository;
import milkteaorder.repository.WorkDayRepository;

@Service
public class WorkDayService {
	@Autowired WorkDayRepository workDayRepo;
	@Autowired StaffWorkDayRepository staffWorkDayRepo;
	@Autowired StaffRepository staffRepo;
	@Autowired JwtTokenUtil jwtTokenUtil;
	
	
	public List<StaffWorkDay> getAllWorkDays() {
		return staffWorkDayRepo.findAll();
	}
	
	public List<StaffWorkDay> getWorkDay(LocalDate date) {
		WorkDay workDay = workDayRepo.findByDate(date);
		if (workDay == null) {
			WorkDay createdWorkDay = workDayRepo.save(new WorkDay(date, false, true, null));
			addStaffToWorkDay(createdWorkDay);
		} else if (!(staffWorkDayRepo.findByWorkDay(date).size() > 0)) {
			addStaffToWorkDay(workDay);
		}
		return staffWorkDayRepo.findByWorkDay(date);
	}
	
	public List<StaffWorkDay> updateWorkHour(String staffId, LocalDate date, float newHour) {
		StaffWorkDay updateSWorkDay = staffWorkDayRepo.findById(new StaffWorkDayKey(staffId, date)).orElseThrow(() -> new NullPointerException());
		updateSWorkDay.setHours(newHour);
		staffWorkDayRepo.save(updateSWorkDay);
		return staffWorkDayRepo.findByWorkDay(date);
	}

	private void addStaffToWorkDay(WorkDay createdWorkDay) {
		List<Staff> staffs = staffRepo.findAll();
		for (Staff staff : staffs) {
			StaffWorkDay staffWorkDay = new StaffWorkDay();
			staffWorkDay.setId(new StaffWorkDayKey(staff.getId_number(), createdWorkDay.getWork_day()));
			staffWorkDay.setStaff(staffRepo.findById(staff.getId_number()).get());
			staffWorkDay.setWorkDay(workDayRepo.findByDate(createdWorkDay.getWork_day()));
			staffWorkDayRepo.save(staffWorkDay);
		}
	}

	public List<WorkDayDto> getWorkDay(HttpServletRequest request) {
		String token = jwtTokenUtil.getAccessToken(request);
		String[] subjectArray = jwtTokenUtil.getSubject(token).split(",");
		String accountId = subjectArray[0];
		Staff staff = staffRepo.findShipperByAccountId(accountId);
		List<StaffWorkDay> staffWorkDays = staffWorkDayRepo.findByStaffId(staff.getId_number());
		List<WorkDayDto> workDayDtos = new ArrayList<>();
		
		for (StaffWorkDay staffWorkDay : staffWorkDays) {
			WorkDay workDay = staffWorkDay.getWorkDay();
			WorkDayDto workDayDto = new WorkDayDto();
			workDayDto.setWorkDay(workDay.getWork_day());
			workDayDto.setHoliday(workDay.is_holiday());
			workDayDto.setHours(staffWorkDay.getHours());
			workDayDtos.add(workDayDto);
		}
		
		return workDayDtos;
	}
}
