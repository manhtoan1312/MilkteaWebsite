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

import milkteaorder.controller.admin.dto.ContactRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Contact;
import milkteaorder.service.ContactService;

@RestController
@RequestMapping("/admin/contact")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminContactInformationController {
	
	@Autowired ContactService contactService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllContacts() {
		List<Contact> contacts = contactService.getAllContact();
		if (contacts == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(contacts);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertContact(@RequestBody ContactRequestDto contactInsert) {
		Contact contactResponse = contactService.insertContact(contactInsert);
		if (contactResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Contact Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(contactResponse);
	}
	
	@PutMapping("/update/{contactId}")
	public ResponseEntity<Object> updateContact(@RequestBody ContactRequestDto contactUpdate, @PathVariable String contactId) {
		Contact contactResponse = contactService.updateContact(contactUpdate, contactId);
		if (contactResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Contact Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(contactResponse);
	}
	
	@PutMapping("/delete/{contactId}")
	public ResponseEntity<Object> deleteContact(@PathVariable String contactId) {
		boolean isDeleted = contactService.deleteContact(contactId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Contact Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Contact Unsuccessfully, please check again !"));
	}
}
