package milkteaorder.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Report;
import milkteaorder.service.ReportService;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins ="http://localhost:3000")
public class ReportController {
	@Autowired ReportService reportService;
	
	@PostMapping("/report")
	public ResponseEntity<?> sendReport(@RequestBody @Valid Report report, HttpServletRequest request) {
		reportService.createReport(report, request);
		return ResponseEntity.ok(new MessageDto("Report sent successfully!!!"));
	}	
}
