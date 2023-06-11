package sg.nus.iss.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.jpa.workshop.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	public List<Address> findByCountry(String country);
	
}
