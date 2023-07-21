package milkteaorder.controller.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDto {
	private String title;
	private String content;
	private String imageUrl;
}
