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

import milkteaorder.controller.admin.dto.MilkteaRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.MilkTea;
import milkteaorder.service.MilkTeaService;

@RestController
@RequestMapping("/admin/milktea")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminMilkteaController {
	
	@Autowired private MilkTeaService milkTeaService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllMilkteas() {
		List<MilkTea> milkteas = milkTeaService.getAllMilkTea();
		if (milkteas == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(milkteas);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertMilktea(@RequestBody MilkteaRequestDto milkteaInsert) {
		MilkTea milkteaResponse = milkTeaService.insertMilktea(milkteaInsert);
		if (milkteaResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Milktea Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(milkteaResponse);
	}
	
	@PutMapping("/update/{milkTeaId}")
	public ResponseEntity<Object> updateMilktea(@RequestBody MilkteaRequestDto milkteUpdate, @PathVariable String milkTeaId) {
		MilkTea milkteaResponse = milkTeaService.updateMilkTea(milkteUpdate, milkTeaId);
		if (milkteaResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Milktea Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(milkteaResponse);
	}
	
	@PutMapping("/delete/{milkTeaId}")
	public ResponseEntity<Object> deleteMilkTea(@PathVariable String milkTeaId) {
		boolean isDeleted = milkTeaService.deleteMilkTea(milkTeaId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Milktea Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Milktea Unsuccessfully, please check again !"));
	}
}
