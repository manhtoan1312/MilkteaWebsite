package milkteaorder.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import milkteaorder.controller.admin.dto.StatisticizeDto;
import milkteaorder.service.OrderService;

@RestController
@RequestMapping("/admin/statisticize")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminStatisticizeController {
	@Autowired private OrderService orderService;
	
	@GetMapping("/get-by-date")
	public ResponseEntity<Object> getByDate(@RequestParam String date) {
		StatisticizeDto result = orderService.statisticizeByDate(date);
		if(result == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(result);
	}

}
