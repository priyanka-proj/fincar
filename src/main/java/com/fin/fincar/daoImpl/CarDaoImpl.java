package com.fin.fincar.daoImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fin.fincar.dao.CarDao;
import com.fin.fincar.model.Car;

@Service
public class CarDaoImpl implements CarDao {
	@Autowired
	JdbcTemplate jdbcTemplate;  
	@Override
	public Car saveCar(Car car){  
	    String query="insert into car values('"+car.getId()+"','"+car.getName()+"','"+car.getManufacturerName()+"','"+car.getModel()+"','"+car.getManufacturingYear()+"','"+car.getColor()+"')";  
	    return jdbcTemplate.queryForObject(query,Car.class);  
	}  
	@Override
	public Car updateCar(Car car){  	
		StringBuilder query = new StringBuilder("update car set");
		        if(car.getName()!=null) {
    	     	query.append("Name='"+car.getName() +"',");
    	        	} 
	    		if(car.getManufacturerName()!=null) {
	    		query.append("ManufacturerName='"+car.getManufacturerName() +"',");
	         		} 
	    		if(car.getModel()!=null) {
		    		query.append("Model='"+car.getModel() +"',");
		    		} 
	    		if(car.getManufacturingYear()!=null) {
		    		query.append("ManufacturingYear='"+car.getManufacturingYear() +"',");
		    		} 
	    		if(car.getColor()!=null) {
		    		query.append("Color='"+car.getColor() +"'");
		    		} 
	    		query.append(" where id='"+car.getId()+"' ");  
	    		int whereIndex= query.indexOf("where");
	    				if(query.substring(whereIndex-2,whereIndex-1)==",") {
	    					query.replace(whereIndex-2,whereIndex-1, " ");
	    				}
	    				System.out.println("update Query - "+query);
	    return jdbcTemplate.queryForObject(query.toString(), Car.class);  
	} 
	@Override
	public Car findCarById(int id) {
	        return this.jdbcTemplate.queryForObject("select * from Car where id = ?", Car.class, 
	        id);
	    }

	    public List<Car> findAllCars() {
	        return this.jdbcTemplate.queryForList("select * from Car", Car.class);
	    }
	    
	@Override
	public int deleteCar(int id){  
	    String deleteQuery="delete from car where id= ?";  
	    return jdbcTemplate.update(deleteQuery, id);  
	}
	public List<Car> findCarsByParams(String name, String manufacturerName, String model, String manufacturingYear, String color) {
		StringBuilder query = new StringBuilder("select * from Car");
				if(name!=null||manufacturerName!=null||model!=null||manufacturingYear!=null||color!=null) {
					query.append("where");
				}
				 if(name!=null) {
		    	     	query.append("Name ='" +name+"' AND");
		    	        	} 
			    		if(manufacturerName!=null) {
			    		query.append("ManufacturerName='"+manufacturerName +"' AND");
			         		} 
			    		if(model!=null) {
				    		query.append("Model='"+model +"'AND");
				    		} 
			    		if(manufacturingYear!=null) {
				    		query.append("ManufacturingYear='"+manufacturingYear +"' AND");
				    		} 
			    		if(color!=null) {
				    		query.append("Color='"+color +"';");
				    		} 
			    		System.out.println("stringBuilder string - " +query.substring(query.length()-3) );
 			    				if(query.substring(query.length()-3).equalsIgnoreCase("AND")) {
			    					query.replace(query.length()-3,query.length()-1, ";");
			    				}
			    				System.out.println("select Query - "+query);
			    return jdbcTemplate.queryForList(query.toString(), Car.class);
		}
	
}
