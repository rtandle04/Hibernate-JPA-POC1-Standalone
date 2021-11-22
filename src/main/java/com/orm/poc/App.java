package com.orm.poc;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.orm.poc.entity.College;
import com.orm.poc.entity.Student;
import com.orm.poc.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Student student1 = new Student(1,"Apple", "Cena", "john@javaguides.com");
        Student student2 = new Student(2,"Banana", "Cena", "john@javaguides.com");
        Student student3 = new Student(3,"Chiku", "Cena", "john@javaguides.com");
        Student student4 = new Student(4,"Danimma", "Cena", "john@javaguides.com");
        College college = new College(1, "CBIT", 2000);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(college);
        session.getTransaction().commit();
        
        Criteria createCriteria = session.createCriteria(Student.class);
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Student> createQuery = builder.createQuery(Student.class);
        
        
        
        
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Class<Student> resultType = query.getResultType();
        
        final List list = createCriteria.list();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
        session.close();
    }
}
