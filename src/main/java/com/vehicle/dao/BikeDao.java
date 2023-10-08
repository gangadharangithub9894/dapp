package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bike;
import com.vehicle.repositary.BikeRepositary;

@Repository
public class BikeDao {
	@Autowired
	BikeRepositary br;

	public String setBike(Bike bike) {
		br.save(bike);
		return "saved";
	}

	public String setAllBike(List<Bike> bikes) {
		br.saveAll(bikes);
		return "saved All";
	}

	public List<Bike> getAllBike() {
		return  br.findAll();
	}

	public Bike getById(int x) {
		
		return br.findById(x).get();
	}

	public String deleteById(int id) {
		br.deleteById(id);
		return "Deleted";
	}

}
