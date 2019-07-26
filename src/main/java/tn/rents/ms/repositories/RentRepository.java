package tn.rents.ms.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import tn.rents.ms.entities.Rent;
@Repository
public interface RentRepository extends MongoRepository<Rent, String> {
	
	@Query("{'user.username':?0}")
	List<Rent> findByUsername(String username);
	

}
