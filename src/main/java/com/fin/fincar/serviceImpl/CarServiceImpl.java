package com.fin.fincar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.fincar.daoImpl.CarDaoImpl;
import com.fin.fincar.model.Car;
import com.fin.fincar.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarDaoImpl carDaoImpl;
	
	@Override
	public Car createCarRecord(Car car)
    {
		return carDaoImpl.saveCar(car);
    }
	@Override
	public Car updateCarRecord(Car car)  
    {               
		return carDaoImpl.updateCar(car);
        
    }
	@Override
	public Car findCarById(int id)
    {
		return carDaoImpl.findCarById(id);
    }
	
	@Override
	public List<Car> getAllcars()
    {
		return carDaoImpl.findAllCars();
    }
	@Override
	public List<Car> findCarsByParams(String name, String manufacturerName, String model, String manufacturingYear, String color)
    {
		return carDaoImpl.findCarsByParams(name,manufacturerName,model,manufacturingYear,color);
    }
	
	@Override
	public void deleteCarRecord(int carId)  
    {               
		carDaoImpl.deleteCar(carId);
        
    }

	/*public boolean checkifCarIsAvailable(Car car) {
		if(car().get(car)!=null) return true;
		return false;
	}*/
}
