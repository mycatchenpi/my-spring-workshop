package sg.nus.iss.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.jpa.workshop.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer>{

	@Query("select f from Facility f where f.name like %:name%")
	public List<Facility> findFacilityByName(@Param("name")String name);
}
