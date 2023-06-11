package iss.persistent.jpql.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
   @Id
   private int id;
   private String name;
   @Column(name = "matric_no")
   private String matricNo;
   private double cap;

   @ManyToOne
   private Department department;

   @ManyToMany
   @JoinTable(name="student_module", 
      joinColumns = @JoinColumn(name = "student_id"), 
      inverseJoinColumns = @JoinColumn(name="module_id"))
   private List<Module> modules;
   
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
   public double getCap() {
      return cap;
   }
   public void setCap(double cap) {
      this.cap = cap;
   }
   public Department getDepartment() {
      return department;
   }
   public void setDepartment(Department department) {
      this.department = department;
   }
   public List<Module> getModules() {
      return modules;
   }
   public void setModules(List<Module> modules) {
      this.modules = modules;
   }
   public String getMatricNo() {
      return matricNo;
   }
   public void setMatricNo(String matricNo) {
      this.matricNo = matricNo;
   }
   @Override
   public String toString() {
      return "Student [id=" + id + ", name=" + name + ", matricNo=" + matricNo + ", CAP=" + cap + "]";
   }
}
