package sg.nus.iss.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.nus.iss.jpa.workshop.model.Member;
import sg.nus.iss.jpa.workshop.model.Person;

@Repository //optional
public interface MemberRepository extends JpaRepository<Member, Integer> {

	//@Query("select p from Person p where p.surName = :name or p.firstName = :name or p:secondName = :name")
	@Query("SELECT m FROM Member m WHERE m.surName = :name OR m.firstName = :name OR m.secondName = :name")
	public List<Member> findMembersByName(@Param("name") String name);	
}
