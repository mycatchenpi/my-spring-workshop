package iss.persistent.jpql.model;

import java.util.List;
import java.security.spec.DSAGenParameterSpec;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class Test {
   public static void main(String[] args) {
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = emFactory.createEntityManager();
      DataService dataService = new DataService(entityManager);

      findAllStudents(dataService);
      System.out.println("--------------- findAllStudentsSortedByMatrcNo ----------------");
      findAllStudentsSortedByMatrcNo(dataService);
      System.out.println("--------------- getStudentesWithN ----------------");
      getStudentesWithN(dataService);
      System.out.println("--------------- getStudentsByListCap -------------");
      getStudentsByListCap(dataService);
      System.out.println("--------------- getStudentsOnPage: page 2 --------------");
      getStudentsOnPage(dataService);
      System.out.println("--------------- getStudentsOfMarvel ---------------");
      getStudentsOfMarvel(dataService);
      System.out.println("--------------- getStudentsWithMan -----------------");
      getStudentsWithMan(dataService);
      System.out.println("--------------- getDepartmentsByAvgCap -----------------");
      getDepartmentsByAvgCap(dataService);
            
      entityManager.close();
      emFactory.close();
   }
   
   static void getStudentByForLoop(List<Student> students) {
	   for(Student student : students) {
		   System.out.println(student.toString());
	   }
   }
   
   static void findAllStudents(DataService ds) {
      List<Student> students = ds.findAllStudents();
      getStudentByForLoop(students);
   }
   
   static void findAllStudentsSortedByMatrcNo(DataService ds) {
	   List<Student> students = ds.findAllStudentsSortedByMatrcNo();
	   getStudentByForLoop(students);
   }
   
   static void getStudentesWithN(DataService ds) {
	   List<Student> students = ds.getStudentesWithN();
	   getStudentByForLoop(students);
   }
   
   static void getStudentsByListCap(DataService ds) {
	   List<Student> students = ds.getStudentsByListCap();
	   getStudentByForLoop(students);
   }
   
   static void getStudentsOnPage(DataService ds) {
	   List<Student> students = ds.getStudentsOnPage(2, 4);
	   getStudentByForLoop(students);
   }
   
   static void getStudentsOfMarvel(DataService ds) {
	   List<Student> students = ds.getStudentsOfMarvel();
	   getStudentByForLoop(students);
   }
   
   static void getStudentsWithMan(DataService ds) {
	   List<Student> students = ds.getStudentsWithMan();
	   for(Student student : students) {
		   System.out.println("student details are: " + student + ", \nmodules details are: ");
		   showModulesByStudent(student);
		   System.out.println();
		   
	   }
   }
   
   static void showModulesByStudent(Student s) {
	   List<Module> modules = s.getModules();
	   for(Module module : modules) {
		   System.out.println(module.toString());
	   }
   }
   
   static void getDepartmentsByAvgCap(DataService ds) {
	   List<Department> departments = ds.getDepartmentsByAvgCap();
	   for(Department d: departments) {
		   System.out.println(d.toString());
	   }
   }
   
}
