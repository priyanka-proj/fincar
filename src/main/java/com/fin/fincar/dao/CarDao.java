package com.fin.fincar.dao;

import javax.sql.DataSource;

import com.fin.fincar.model.Car;

public interface CarDao {

	Car saveCar(Car car);

	Car updateCar(Car car);

	int deleteCar(int id);

	Car findCarById(int id);
}
