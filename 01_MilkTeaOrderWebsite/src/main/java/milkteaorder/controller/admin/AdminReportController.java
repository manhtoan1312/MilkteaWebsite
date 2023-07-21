package milkteaorder.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Report;
import milkteaorder.service.ReportService;

@RestController
@RequestMapping("/admin/report")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminReportController {
	
	@Autowired private ReportService reportService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllReports() {
		List<Report> reports = reportService.getAllReports();
		if (reports == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(reports);
	}
	
	@GetMapping("/get-report")
	public ResponseEntity<Object> getReportDetail(@RequestParam String reportId) {
		Report report = reportService.getReportDetail(reportId);
		if (report == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(report);
	}
	
	@PutMapping("/delete/{reportId}")
	public ResponseEntity<Object> deleteReport(@PathVariable String reportId) {
		boolean isDeleted = reportService.deleteReport(reportId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Report Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Report Unsuccessfully, please check again !"));
	}
	
	@PutMapping("/have-read/{reportId}")
	public ResponseEntity<Object> haveReadReport(@PathVariable String reportId) {
		boolean isRead = reportService.haveReadReport(reportId);
		if (isRead) {
			return ResponseEntity.ok(new MessageDto("Update Report State Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Update Report State Unsuccessfully, please check again !"));
	}
}
