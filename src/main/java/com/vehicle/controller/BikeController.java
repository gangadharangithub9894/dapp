package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bike;
import com.vehicle.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	BikeService bs;

	@PostMapping(value = "/setBike")
	public String setBike(@RequestBody Bike bike) {
		return bs.setBike(bike);
	}

	@PostMapping(value = "/setAllBike")
	public String setAllBike(@RequestBody List<Bike> bikes) {
		return bs.setAllBike(bikes);
	}

	@GetMapping(value = "/getAllBike")
	public List<Bike> getAllBike() {
		return bs.getAllBike();
	}

	@GetMapping(value = "/getById/{x}")
	public Bike getById(@PathVariable int x) {
		return bs.getById(x);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return bs.deleteById(id);
	}

	@GetMapping("/getByBrand/{b}")
	public List<Bike> getByBrand(@PathVariable String b) {
		return bs.getByBrand(b);
	}

	@GetMapping("/getByRange/{a}/{b}")
	public List<Bike> getByBrand(@PathVariable int a, @PathVariable int b) {
		return bs.getByRange(a, b);
	}

	@GetMapping("/getBrandByColor/{c}")
	public List<String> getBrandByColor(@PathVariable String c) {
		return bs.getBrandByColor(c);
	}

	@GetMapping("/getMax")
	public Bike getMax() {
		return bs.getMax();
	}

	@GetMapping("/getMin")
	public Bike getMin() {
		return bs.getMin();
	}

	@GetMapping("/getReducedBike/{x}")
	public List<Bike> getReducedBike(@PathVariable int x) {
		return bs.getReducedBike(x);
	}
	
	//petrolBike count
	@GetMapping("/getBikeTcount/{f}")
	public Long getBikeTcount(@PathVariable String f) {
		return bs.getBikeTcount(f);
		
		}

}
