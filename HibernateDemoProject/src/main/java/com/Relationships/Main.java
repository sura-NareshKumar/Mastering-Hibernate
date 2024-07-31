package com.Relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = getConfiguration();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();

	}

	private static Configuration getConfiguration() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		return cfg;
	}

	private static void manyToMany(Configuration cfg, Session session) {
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Course.class);
		Student s1 = new Student();
		s1.setName("naresh");
		Student s2 = new Student();
		s2.setName("suresh");
		Course c1 = new Course();
		c1.setTitle("JFS");
		Course c2 = new Course();
		c2.setTitle("JFS");
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s2.getCourses().add(c1);
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c2.getStudents().add(s1);
		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);
	}

	private static void oneToMany(Configuration cfg, Session session) {
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Product.class);
		Customer customer = new Customer();
		customer.setC_name("naresh");

		Product p1 = new Product();
		p1.setP_name("shampoo");
		Product p2 = new Product();
		p2.setP_name("facewash");
		p1.setCustomer(customer);
		p2.setCustomer(customer);

		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		customer.setProduct(list);
		session.save(customer);
	}

	private static void oneToOne(Configuration cfg, Session session) {
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Aadhar.class);
		Aadhar aadhar = new Aadhar();
		aadhar.setAadharNo(12345);
		Person person = new Person();
		person.setPersonName("naresh");
		person.setAadharId(aadhar);
		session.save(person);
	}

}
