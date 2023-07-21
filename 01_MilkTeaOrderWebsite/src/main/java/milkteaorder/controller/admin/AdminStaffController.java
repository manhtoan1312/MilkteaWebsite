package milkteaorder.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import milkteaorder.controller.admin.dto.StaffRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Staff;
import milkteaorder.service.StaffService;

@RestController
@RequestMapping("/admin/staff")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminStaffController {
	
	@Autowired private StaffService staffService;
	
	@GetMapping("/get-staff-list/{role}")
	public ResponseEntity<Object> getStaffList(@PathVariable String role) {
		List<Staff> staffs = staffService.getStaffList(role);
		if (staffs == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(staffs);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertStaff(@RequestBody StaffRequestDto staffInsert) {
		Staff staffResponse = staffService.insertStaff(staffInsert);
		if (staffResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Staff Unsuccessfully, duplicate Email, Id or Phone Number !"));
		}
		return ResponseEntity.ok(staffResponse);
	}
	
	
	@PutMapping("/update/{staffId}")
	public ResponseEntity<Object> updateStaff(@RequestBody StaffRequestDto staffUpdate, @PathVariable String staffId) {
		Staff staffResponse = staffService.updateStaff(staffUpdate, staffId);
		if (staffResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Staff Unsuccessfully, not found staff or duplicate data, please check again !"));
		}
		return ResponseEntity.ok(staffResponse);
	}
	
	@PutMapping("/delete/{staffId}")
	public ResponseEntity<Object> deleteStaff(@PathVariable String staffId) {
		boolean isDeleted = staffService.deleteStaff(staffId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Staff Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Staff Unsuccessfully, please check again !"));
	}
}
