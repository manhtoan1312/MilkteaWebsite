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
import milkteaorder.controller.admin.dto.BlogRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Blog;
import milkteaorder.service.BlogService;

@RestController
@RequestMapping("/admin/blog")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminBlogController {

	@Autowired BlogService blogService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllBlogs() {
		List<Blog> blogs = blogService.getAllBlogs();
		if (blogs == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(blogs);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertBlog(@RequestBody BlogRequestDto blogInsert, HttpServletRequest request) {
		Blog blogResponse = blogService.insertBlog(blogInsert, request);
		if (blogResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Blog Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(blogResponse);
	}
	
	@PutMapping("/update/{blogId}")
	public ResponseEntity<Object> updateBlog(@RequestBody BlogRequestDto contactUpdate, @PathVariable String blogId, HttpServletRequest request) {
		Blog blogResponse = blogService.updateBlog(contactUpdate, blogId, request);
		if (blogResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Blog Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(blogResponse);
	}
	
	@PutMapping("/delete/{blogId}")
	public ResponseEntity<Object> deleteContact(@PathVariable String blogId) {
		boolean isDeleted = blogService.deleteBlog(blogId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Blog Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Blog Unsuccessfully, please check again !"));
	}
}
