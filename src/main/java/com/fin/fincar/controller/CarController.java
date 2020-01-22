package com.fin.fincar.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.fincar.model.Car;
import com.fin.fincar.serviceImpl.CarServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/fincar", produces = "application/json")
@Api(value = "fincar", produces = "application/json")
public class CarController {
	 @Autowired
	  private CarServiceImpl carSeriveImpl;

	  @PostMapping()
	  public Car createCarRecord(@Valid @RequestBody Car car) {
		  
	      return carSeriveImpl.createCarRecord(car);
	  }
	  @GetMapping("/test")
	  public String createCartestRecord() {
		  
	      return "test";
	  }
	  @PutMapping()
	  public Car updateCarRecord(@RequestBody Car car) {									
		  return carSeriveImpl.updateCarRecord(car);
	  }
	  @GetMapping("/get")
	  public List<Car> getAllCars() {
	      List<Car> cars = carSeriveImpl.getAllcars();
	      return cars;
	  }
	  @GetMapping("/all")
	  public List<Car> getCar() {
	      List<Car> cars = carSeriveImpl.getAllcars();
	      return cars;
	  }
	  
	  @GetMapping("{carId}")
	  public Car findCarById(@NotNull @PathVariable("carId") int carId) {
		  return carSeriveImpl.findCarById(carId);
	  }
	  
	  //search implementation
	  @GetMapping(value = "/search")
	  public List<Car> list(@RequestParam(value = "name", required = false) String name,
		                             @RequestParam(value = "manufacturerName", required = false) String manufacturerName,
		                             @RequestParam(value = "model", required = false) String model,
		                             @RequestParam(value = "manufacturingYear", required = false) String manufacturingYear,
		                             @RequestParam(value = "color", required = false) String color) {
			return carSeriveImpl.findCarsByParams(name,manufacturerName,model,manufacturingYear,color);
		}

	  	  
	  @DeleteMapping("delete/{carId}")
	  public void deleteCar(@NotNull @PathVariable("carId") int carId)  {
	      carSeriveImpl.deleteCarRecord(carId);
	    
	  }

}
