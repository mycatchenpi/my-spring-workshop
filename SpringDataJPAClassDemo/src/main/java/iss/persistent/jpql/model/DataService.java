package iss.persistent.jpql.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.ws.BindingType;

import org.hibernate.usertype.LoggableUserType;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class DataService {

   protected EntityManager em;

   public DataService(EntityManager entityManager) {
      em = entityManager;
   }

   public List<Student> findAllStudents() {
      String q = "SELECT s FROM Student s";
      
      return (List<Student>) em.createQuery(q).getResultList();
   }
   
   public List<Student> findAllStudentsSortedByMatrcNo() {
	   String q = "select s from Student s order by s.matricNo";
	   return (List<Student>)em.createQuery(q).getResultList();
   }
   
   public List<Student> getStudentesWithN() {
	TypedQuery<Student> query = em.createQuery("select s from Student s where s.name like '%n'", Student.class);
	return query.getResultList();
   }
   
   public List<Student> getStudentsByListCap() {
	   TypedQuery<Student> query = em.createQuery("select s from Student s where s.cap >= 3.0", Student.class);
	   List<Student> students = query.getResultList();
	   return students;
   }
   
   public List<Student> getStudentsOnPage(int page, int maxNo) {
	   TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
	   return query.setFirstResult((page - 1) * maxNo).setMaxResults(maxNo).getResultList();
   }
   
   public List<Student> getStudentsOfMarvel() {
	   TypedQuery<Student> query = em.createQuery("select s from Student s "
	   		+ "where s.department.name = 'Marvel' "
	   		+ "and s.cap > 2.5", Student.class);
	   return query.getResultList();
   }
   
   public List<Student> getStudentsWithMan() {
	   TypedQuery<Student> query = em.createQuery("select s from Student s where s.name like '%man%'", Student.class);
	   return query.getResultList();
   }
   
   public List<Department> getDepartmentsByAvgCap() {
	   String q = "select d from Department d "
	   		+ "join d.students s "
	   		+ "group by d "
	   		+ "having AVG(s.cap) > 2.5";  // having for filtering groups, where for filtering rows
	   List<Department> departments = (List<Department>)em.createQuery(q).getResultList();;
	   return departments;
   }
}
