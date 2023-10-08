package com.vehicle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdNotFoundException;
import com.vehicle.customexception.InvalidBoardException;
import com.vehicle.dao.BusDao;
import com.vehicle.entity.Bus;

@Service
public class BusService {
	@Autowired
	BusDao bd;

	public String setBus(Bus bus) throws InvalidBoardException {
		// try {
		if (bus.getBoard().equalsIgnoreCase("WhiteBoard")) {
			return bd.setBus(bus);
		} else {
			throw new InvalidBoardException("Invalid board");
		}
		// } catch (InvalidBoardException i) {
		// return "Invalid Data";

		// }
	}

	public String setAllBus(List<Bus> buss) throws InvalidBoardException {

		List<Bus> s = buss.stream().filter(
				x -> x.getBoard().equalsIgnoreCase("WhiteBoard") || x.getBoard().equalsIgnoreCase("YellowBoard"))
				.collect(Collectors.toList());

		if (s.isEmpty()) {
			throw new InvalidBoardException("Invalid data");
		} else {
			return bd.setAllBus(s);
		}

	}

	public List<Bus> getAllBus() {
		return bd.getAllBike();
	}

	public Bus getById(int id) throws IdNotFoundException {

		return bd.getById(id);
	}

	public List<Bus> getByBrand(String b) throws BrandNotFoundException {

		List<Bus> x = bd.getByBrand(b);

		if (x.isEmpty()) {
			throw new BrandNotFoundException("try to take invalid object getbybrand");
		} else {
			return x;
		}

	}

	public String update(int i, Bus bus) throws IdNotFoundException, InvalidBoardException {

		Bus x = getById(i);
		Bus y = bus;
		x.setId(i);
		x.setName(y.getName());
		x.setBoard(y.getBoard());
		x.setColor(y.getColor());
		return setBus(x);

	}

}
