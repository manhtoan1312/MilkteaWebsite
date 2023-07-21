package milkteaorder.controller.staffmanager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milkteaorder.controller.customer.dto.IngredientRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Ingredient;
import milkteaorder.service.IngredientService;

@RestController
@RequestMapping("/staff-manager")
@CrossOrigin(origins ="http://localhost:3000")
public class SMIngredientController {
	@Autowired IngredientService ingredientService;
	
	@GetMapping("/manage-ingredients")
	public ResponseEntity<?> getIngredients(HttpServletRequest request) {
		List<Ingredient> ingredients = ingredientService.getIngredientsManage(request);
		if (ingredients.size()>0) {
			return ResponseEntity.ok(ingredients);
		}
		return ResponseEntity.ok(new MessageDto("No ingredients!!!"));
	}
	
	@PutMapping("/manage-ingredients/update")
	public ResponseEntity<?> updateIngredients(@RequestBody IngredientRequestDto content) {
		Ingredient ingredient = ingredientService.getIngredientById(content.getId());
		ingredient.setQuantity(content.getQuantity());
		ingredient.setNote(content.getNote());
		ingredient.setLast_update(new Date());
		ingredientService.updateIngredient(ingredient);
		return ResponseEntity.ok(new MessageDto("Ingredient informations updated successfully!!!"));
	}
}
