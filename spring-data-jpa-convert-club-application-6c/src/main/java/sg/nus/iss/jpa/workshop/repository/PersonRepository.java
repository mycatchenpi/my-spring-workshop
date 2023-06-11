package sg.nus.iss.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.nus.iss.jpa.workshop.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{}
