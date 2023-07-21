package milkteaorder.controller.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRequestDto {
	private String id;
	private int quantity;
	private String note;
}
