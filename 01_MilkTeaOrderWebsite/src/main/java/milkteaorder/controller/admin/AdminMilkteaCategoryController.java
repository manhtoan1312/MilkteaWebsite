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
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.MilkTeaCategory;
import milkteaorder.service.MilkTeaCategoryService;

@RestController
@RequestMapping("/admin/category")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminMilkteaCategoryController {
	
	@Autowired private MilkTeaCategoryService milkTeaCategoryService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllCategories() {
		List<MilkTeaCategory> categories = milkTeaCategoryService.getAllCategories();
		if (categories == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertCategory(@RequestBody MilkTeaCategory milkTeaCategoryInsert) {
		MilkTeaCategory categoryResponse = milkTeaCategoryService.insertCategory(milkTeaCategoryInsert);
		if (categoryResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert MilkTea Category Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(categoryResponse);
	}
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<Object> updateMilkTeaCategory(@RequestBody MilkTeaCategory milkteaCategoryUpdate, @PathVariable String categoryId) {
		milkteaCategoryUpdate = milkTeaCategoryService.updateMilkTeaCategory(milkteaCategoryUpdate, categoryId);
		if (milkteaCategoryUpdate == null) {
			return ResponseEntity.ok(new MessageDto("Update Milktea Category Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(milkteaCategoryUpdate);
	}
	
	@PutMapping("/delete/{categoryId}")
	public ResponseEntity<Object> deleteMilkTeaCategory(@PathVariable String categoryId) {
		boolean isDeleted = milkTeaCategoryService.deleteMilkTeaCategory(categoryId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Milktea Category Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Milktea Category Unsuccessfully, please check again !"));
	}
	
}
