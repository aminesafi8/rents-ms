package tn.rents.ms.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {
	@Id
	private String id;
	private String plate;
	

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	

	@Override
	public String toString() {
		return "Car [id=" + id + ", plate=" + plate + "]";
	}

}
