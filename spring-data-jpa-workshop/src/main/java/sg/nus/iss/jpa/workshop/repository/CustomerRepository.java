package sg.nus.iss.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.jpa.workshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c join c.addresses a where a.country = :country")
	public List<Customer> findByAddressCountry(@Param("country") String country);
}
