package sg.nus.iss.jpa.workshop;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jpa.workshop.model.Facility;
import sg.nus.iss.jpa.workshop.model.Member;
import sg.nus.iss.jpa.workshop.repository.FacilityRepository;
import sg.nus.iss.jpa.workshop.repository.MemberRepository;
import sg.nus.iss.jpa.workshop.repository.PersonRepository;

@SpringBootApplication
public class SpringDataJpaConvertClubApplication6cApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaConvertClubApplication6cApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commanLineRun(FacilityRepository facilityRepo, MemberRepository memberRepo, PersonRepository personRepo) {
		return args -> {
			Member m1 = memberRepo.save(new Member( "Einstein", "Albert", "",101));
			Member m2 = memberRepo.save(new Member("Picasso", "Pablo", "Ruiz", 102));
			List<Member> members = memberRepo.findAll();
			members.forEach(member -> System.out.println(member));
			
			//update a record of members
			System.out.println("--------update memberNumber for a record of members");
			int memberNumberUpdated = 200;
			for(Member m : members) {
				if(memberRepo.existsById(m.getId())) {
					m.setMemberNumber(memberNumberUpdated);
					
					// here must use .save() to update data to DB
					memberRepo.save(m);  
					memberNumberUpdated += 1;
				} else {
					System.out.println("There is no member to update");
				}
			}
			members.forEach(member -> System.out.println(member));
			
			// get id of the first member
			System.out.println("------------get id of the first member");
			members = memberRepo.findAll();
			int firstId = members.get(0).getId();
			System.out.println("firstId = " + firstId);
			
			//update mumberNumber by id
			System.out.println("------------update mumberNumber by id");
			int newMumberNumber = 303;
			int id = 3;
			try {
				Member m = memberRepo.findById(id).get();
				m.setMemberNumber(newMumberNumber);
				memberRepo.save(m);
				System.out.println(m);
			}catch(IllegalStateException e) {
				System.out.println("Error message = " + e.getMessage());
			}catch(Exception e) {
				System.out.println("There is no member to update");
				System.out.println("Error message = " + e.getMessage());
			} 
			
			//find member by name
			System.out.println("----------find member by name");
			String name = "B";
			members = memberRepo.findMembersByName(name);
			if(members != null && members.size() > 0) {
				members.forEach(member -> System.out.println(member));
			}else {
				System.out.println("There is no member has a name with " + name);
			}
			
			//remove member by id
			System.out.println("----------remove member by id");
			id = 1;
			if(memberRepo.existsById(id)) {
				memberRepo.deleteById(id);
			}
			
			System.out.println("----------create and list all facilities");
			facilityRepo.save(new Facility("Chair", "Office chair"));
			facilityRepo.save(new Facility("Meeting room 3A", "Meeting room at 3rd floor"));
			facilityRepo.save(new Facility("Meeting room 3B", "Meeting room at 3rd floor"));
			facilityRepo.save(new Facility("Meeting room 4A", "Meeting room at 4th floor"));
			List<Facility> facilities = facilityRepo.findAll();
			facilities.forEach(facility -> System.out.println(facility));
			
			System.out.println("---------- update facility by id");
			id = 1;
			//String newName = "Super chair";
			//String newDescription = "Chair for supper";
			String newName = "Super chair", newDescription = "Chair for supper";
			if(facilityRepo.existsById(id)) {
				Facility f = facilityRepo.findById(id).get(); // findById() returns Optional<Facility>
				f.setName(newName);
				f.setDescription(newDescription);
				facilityRepo.save(f);
				System.out.println(f);
			}else {
				System.out.println("Cannot find a facility with id " + id);
			}
			
			System.out.println("---------- list facility by name");
			name = "room";
			facilities = facilityRepo.findFacilityByName(name);
			facilities.forEach(facility -> System.out.println(facility));
		};
		
	}
}
