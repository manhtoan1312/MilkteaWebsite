package milkteaorder.controller.customer.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import milkteaorder.model.AddOn;
import milkteaorder.model.MilkTea;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilkTeaDetailDto {
	private MilkTea milkTea;
	private List<AddOn> allAddOns;
}
