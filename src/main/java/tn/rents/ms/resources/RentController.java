package tn.rents.ms.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.rents.ms.entities.Car;
import tn.rents.ms.entities.Rent;
import tn.rents.ms.entities.User;
import tn.rents.ms.services.RentService;

@RestController
@RequestMapping("rent")
public class RentController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	RentService rentService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public ResponseEntity<String> addRent(@RequestParam String username, @RequestParam String plate) {

		User user = restTemplate.getForObject("http://users-ms/user/" + username, User.class);
		Car car = restTemplate.getForObject("http://cars-ms/car/" + plate, Car.class);

		rentService.addRent(user, car);

		return new ResponseEntity<String>("rent as added!!", HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Rent>> getRentsByUsername(@RequestParam String username) {
		//I can get the user directly from the RentService but I wanted to invoke another micro-service
		User user = restTemplate.getForObject("http://users-ms/user/" + username, User.class);
		rentService.findRentsByUsername(user.getUsername());
		return new ResponseEntity<List<Rent>>(rentService.findRentsByUsername(user.getUsername()), HttpStatus.OK);
	}

}
