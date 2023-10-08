package com.vehicle.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.BikeDao;
import com.vehicle.entity.Bike;

@Service
public class BikeService {
	@Autowired
	BikeDao bd;

	public String setBike(Bike bike) {
		return bd.setBike(bike);
	}

	public String setAllBike(List<Bike> bikes) {

		return bd.setAllBike(bikes);
	}

	public List<Bike> getAllBike() {
		return bd.getAllBike();
	}

	public Bike getById(int x) {
		return bd.getById(x);
	}

	public String deleteById(int id) {
		return bd.deleteById(id);
	}
	//without queries

	public List<Bike> getByBrand(String b) {
		List<Bike> x=getAllBike();
		List<Bike> y=x.stream().filter(m->m.getBrand().equalsIgnoreCase(b)).collect(Collectors.toList());
		
		return y;
	}

	public List<Bike> getByRange(int a, int b) {
	List<Bike> x=getAllBike();
	List<Bike> y=x.stream().filter((m->m.getPrice()>a&&m.getPrice()<b)).collect(Collectors.toList());
		return y;
	}

	public List<String> getBrandByColor(String c) {
		List<Bike> x=getAllBike();
		List<String> y=x.stream().filter(z->z.getColor().equals(c)).map(m->m.getBrand()).collect(Collectors.toList());
		return y;
	}

	public Bike getMax() {
		List<Bike> x=getAllBike();
		Bike max=x.stream().max(Comparator.comparing(Bike::getPrice)).get();
		
		return max;
	}

	public Bike getMin() {
		List<Bike> x=getAllBike();
		Bike min=x.stream().min(Comparator.comparing(Bike::getPrice)).get();
		
		return min;
	}
    //getReducedBike out from peekMethod()
	public List<Bike> getReducedBike(int x) {
		List<Bike> p=getAllBike();
		List<Bike> y=p.stream().peek(z->z.setPrice(z.getPrice()-z.getPrice()*x/100)).collect(Collectors.toList());		
		return y;
	}

	public Long getBikeTcount(String f) {
		//List<Bike> b=getAllBike();
		//Long count=b.stream().filter(x->x.getFuelType().equals(f)).count();
		//return count;
		
		return getAllBike().stream().filter(x->x.getFuelType().equalsIgnoreCase(f)).count();
	}

	//getReducedBike output from another map method()
//	public List<Bike> getReducedBike(int x) {
//		List<Bike> p=getAllBike();
//		List<Bike> netPrice=p.stream().map((n)->{
//			int prePrice=n.getPrice();
//			int disPrice=prePrice-(prePrice*x/100);
//			n.setPrice(disPrice);
//			return n;
//		}).collect(Collectors.toList());
//
//		return netPrice;
//	}
	
	
	

}
