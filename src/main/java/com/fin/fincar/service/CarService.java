package com.fin.fincar.service;

import java.util.List;

import com.fin.fincar.model.Car;

public interface CarService {

	Car createCarRecord(Car car);

	Car updateCarRecord(Car car);

	List<Car> getAllcars();

	void deleteCarRecord(int carId);

	List<Car> findCarsByParams(String name, String manufacturerName, String model, String manufacturingYear,
			String color);

	Car findCarById(int id);
	

}
