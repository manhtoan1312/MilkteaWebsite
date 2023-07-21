package milkteaorder.controller.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto {
	private String email;
	private String password;
	private String role;
	private String name;
	private String phone;
	private String address;
}
