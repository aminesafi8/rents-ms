package tn.rents.ms.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import tn.rents.ms.entities.Car;
import tn.rents.ms.entities.Rent;
import tn.rents.ms.entities.User;
import tn.rents.ms.repositories.RentRepository;

@Service
public class RentService {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	RentRepository rentRepository;

	public String addRent(User user, Car car) {
		Rent rent = new Rent();
		rent.setRentDate(new Date());
		rent.setUser(user);
		rent.setCar(car);

		rentRepository.save(rent);
		return "rent added!";
	}
	
	
	public List<Rent> findRentsByUsername(String username){
		return rentRepository.findByUsername(username);
		
	}

}
