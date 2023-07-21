package milkteaorder.controller.staffmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milkteaorder.controller.customer.dto.CustomMilkTeaDto;
import milkteaorder.controller.customer.dto.CustomOrderDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.globalenum.EOrderSate;
import milkteaorder.model.AddOn;
import milkteaorder.model.CustomMilkTea;
import milkteaorder.model.Order;
import milkteaorder.service.CustomMilkTeaService;
import milkteaorder.service.OrderService;

@RestController
@RequestMapping("/staff-manager")
@CrossOrigin(origins ="http://localhost:3000")
public class SMOrderController {
	@Autowired OrderService orderService;
	@Autowired CustomMilkTeaService customMilkTeaService;
	
	//Get all orders passedToStaff
	@GetMapping()
	public ResponseEntity<?> getAllOrders() {
		List<CustomOrderDto> ordersDtos = new ArrayList<>();
		List<Order> ordersPassedToStaff = orderService.getOrderPassedToStaff();
		if (!(ordersPassedToStaff.size() > 0)) {
			return ResponseEntity.ok(new MessageDto("No order!!!"));
		}
		
		for (Order order : ordersPassedToStaff) {
			List<CustomMilkTea> customMilkTeasInOrder = customMilkTeaService.getCustomMilkTeaInCart(order.getOrder_id());
			List<CustomMilkTeaDto> customMilkTeaDtos = new ArrayList<>();
			//get all add-on name
			for (CustomMilkTea customMilkTea : customMilkTeasInOrder) {
				List<String> addOns = new ArrayList<>();
				for (AddOn addOn : customMilkTea.getAddOn()) {
					addOns.add(addOn.getName());
				}
				CustomMilkTeaDto customMilkTeaDto = new CustomMilkTeaDto(customMilkTea.getMilkTea().getName(),
						customMilkTea.getIce_amount(), customMilkTea.getSugar_amount(), customMilkTea.getSize(),
						customMilkTea.getQuantity(), addOns);
				customMilkTeaDtos.add(customMilkTeaDto);
			}
			ordersDtos.add(new CustomOrderDto(order.getOrder_id(), order.getNote(), order.getPhone(), customMilkTeaDtos));
		}
		
		return ResponseEntity.ok(ordersDtos);
	}
	
	@PutMapping("/accept-order/{orderId}")
	public ResponseEntity<?> passOrderToShipper(@PathVariable String orderId) {
		return ResponseEntity.ok(new MessageDto(orderService.passOrderToShipperOrCancel(orderId, EOrderSate.PassedToShipper.toString())));
	}
	
	@PutMapping("/cancel-order/{orderId}")
	public ResponseEntity<?> cancelOrderByStaff(@PathVariable String orderId) {
		return ResponseEntity.ok(new MessageDto(orderService.passOrderToShipperOrCancel(orderId, EOrderSate.CanceledByStaff.toString())));
	}
}
