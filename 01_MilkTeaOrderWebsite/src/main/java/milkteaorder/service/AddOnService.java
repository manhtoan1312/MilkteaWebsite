package milkteaorder.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import milkteaorder.model.AddOn;
import milkteaorder.repository.AddOnRepository;

@Service
public class AddOnService {
	@Autowired AddOnRepository addOnRepository;
	
	public AddOn getAddOnById(String id) {
		return addOnRepository.findById(id).orElseThrow(() -> new NullPointerException());
	}
	
	public List<AddOn> getAllAddOns() {
		return addOnRepository.findAll();
	}
}
