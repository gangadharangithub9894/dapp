package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.customexception.IdNotFoundException;
import com.vehicle.entity.Bus;
import com.vehicle.repositary.BusRepository;

@Repository
public class BusDao {
	@Autowired
	BusRepository br;

	public String setBus(Bus bus) {
		br.save(bus);
		return "Saved data";
	}

	public String setAllBus(List<Bus> buss) {
		br.saveAll(buss);
		return "Saved All";
	}

	public List<Bus> getAllBike() {
		return br.findAll();
		
	}

	public Bus getById(int id) throws IdNotFoundException {
		return br.findById(id).orElseThrow(()->new IdNotFoundException("id doesn't not available"));
	}

	public List<Bus> getByBrand(String b) {
		return br.getByBrand(b); 
	}

}
