package milkteaorder.model.api;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class AuthRequest {
	@Email @Length(min = 5, max = 40)
	@Nullable
	private String email;
	
	@Length(min = 1, max = 20)
	@Nullable
	private String password;
	
	@Length(min = 1, max = 12)
	@Nullable
	private String otp;
	
}
