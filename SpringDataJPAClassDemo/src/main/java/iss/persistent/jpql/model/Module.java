package iss.persistent.jpql.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Module {
   @Id
   private int id;
   @Column(name = "m_code")
   private String code;
   private String description;
   
   @ManyToMany (mappedBy = "modules")
   private List<Student> students;
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public List<Student> getStudents() {
      return students;
   }
   public void setStudents(List<Student> students) {
      this.students = students;
   }
   @Override
   public String toString() {
      return "Module [id=" + id + ", code=" + code + ", description=" + description + "]";
   }
}
