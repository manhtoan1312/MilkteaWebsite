package milkteaorder.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import milkteaorder.controller.admin.dto.IngredientRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Ingredient;
import milkteaorder.service.IngredientService;

@RestController
@RequestMapping("/admin/ingredient")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminIngredientController {
	
	@Autowired private IngredientService ingredientService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllIngredients() {
		List<Ingredient> ingredients = ingredientService.getAllIngredients();
		if (ingredients == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(ingredients);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertIngredient(@RequestBody IngredientRequestDto milkteaInsert, HttpServletRequest request) {
		Ingredient ingredientResponse = ingredientService.insertIngredient(milkteaInsert, request);
		if (ingredientResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Ingredient Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(ingredientResponse);
	}
	
	@PutMapping("/update/{ingredientId}")
	public ResponseEntity<Object> updateIngredient(@RequestBody IngredientRequestDto ingredientUpdate, @PathVariable String ingredientId,
			HttpServletRequest request) {
		Ingredient ingredientResponse = ingredientService.updateIngredient(ingredientUpdate, ingredientId, request);
		if (ingredientResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Ingredient Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(ingredientResponse);
	}
	
	@PutMapping("/delete/{ingredientId}")
	public ResponseEntity<Object> deleteIngredient(@PathVariable String ingredientId) {
		boolean isDeleted = ingredientService.deleteIngredient(ingredientId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Ingredient Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Ingredient Unsuccessfully, please check again !"));
	}
}
