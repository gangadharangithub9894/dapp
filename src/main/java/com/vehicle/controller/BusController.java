package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdNotFoundException;
import com.vehicle.customexception.InvalidBoardException;
import com.vehicle.entity.Bus;
import com.vehicle.service.BusService;

@CrossOrigin(origins=" http://localhost:4200")
@RestController
@RequestMapping(value = "/bus")
public class BusController {
	@Autowired
	BusService bs;

	@PostMapping(value = "/setBus")
	public String setBus(@RequestBody Bus bus) throws InvalidBoardException {
		return bs.setBus(bus);
	}

	@PostMapping(value = "/setAllBus")
	public String setAllBus(@RequestBody List<Bus> buss) throws InvalidBoardException {
		return bs.setAllBus(buss);

	}
	
	@GetMapping("/getAllBus")
	public List<Bus> getAllBus(){
		return bs.getAllBus();
	}
	
	@GetMapping("/getById/{id}")
	public Bus getById(@PathVariable int id) throws IdNotFoundException {
		return bs.getById(id);
	}
	
	@GetMapping("/getByBrand/{b}")
	public List<Bus> getByBrand(@PathVariable String b) throws BrandNotFoundException{
		return bs.getByBrand(b);
	}
	
	@PutMapping(value="/update/{i}")
	public String update(@PathVariable int i,@RequestBody Bus bus) throws IdNotFoundException, InvalidBoardException {
		return bs.update(i,bus);
	}
	
	

}
