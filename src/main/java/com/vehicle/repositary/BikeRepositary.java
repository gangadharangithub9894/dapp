package com.vehicle.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.entity.Bike;

public interface BikeRepositary extends JpaRepository<Bike, Integer>{

}
