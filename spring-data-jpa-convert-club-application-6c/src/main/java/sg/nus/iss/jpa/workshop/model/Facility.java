package sg.nus.iss.jpa.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String description;
		
		//constructors
		public Facility() {}
		public Facility(String name) {
			this(name, null);
		}
		public Facility(String name, String description) {
			this.name = name; 
			this.description = description;
		}
		
		//getters and setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		//toString
		@Override
		public String toString() {
			String fullName = name;
			if(description != null) {
				fullName += " (" + description + ") ";
			}
			return fullName;
		}
		
}
