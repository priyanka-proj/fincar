package com.fin.fincar.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Car {
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String manufacturerName;
	@NotNull
	private String model;
	@NotNull
	private String manufacturingYear;
	@NotNull
	private String color;

	public Car(int id,String name,String manufacturerName,String model,String manufacturingYear,String color)
	{
		this.id=id;
		this.name=name;
		this.manufacturerName=manufacturerName;
		this.model=model;
		this.manufacturingYear=manufacturingYear;
		this.color=color;
	}

}