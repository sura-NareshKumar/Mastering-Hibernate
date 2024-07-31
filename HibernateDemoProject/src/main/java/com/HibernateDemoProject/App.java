package com.HibernateDemoProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		Employee employeeObj = new Employee();
		employeeObj.setName("naresh");
		employeeObj.setAge(22);
		Address adr = new Address();
		adr.setDoorNO(143);
		adr.setCity("palasa");
		employeeObj.setAddress(adr);

		org.hibernate.SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		tx.commit();
		session.close();
	}

	private static void namedQuery(Session session) {
		Query namedQuery = session.getNamedQuery("call");
		System.out.println(namedQuery.list());
	}

	private static void demoSQL(Session session) {
		NativeQuery<Employee> query = session.createNativeQuery("select * from employee_data", Employee.class);
		List<Employee> list = query.list();
		System.out.println(list);
	}

	private static void demoHQL(Session session) {
		Query queryObj = session.createQuery("update Employee emp set emp.address.city=:city where emp.id=?2");

		queryObj.setParameter("city", "hyd");
		queryObj.setParameter(2, 1);

		queryObj.executeUpdate();
	}

	private static void deleteOps(Session session) {
		Employee employee = session.get(Employee.class, 1);
		session.delete(employee);
	}

	private static void updateOps(Session session) {
		Employee employee = session.get(Employee.class, 1);
		employee.setName("naresh kumar");
		session.update(employee);
	}

	private static void readOps(Session session) {
		Employee employee = session.get(Employee.class, 1); // eager loading
		System.out.println(employee);
		Employee employee1 = session.load(Employee.class, 1); // lazy loading
		System.out.println(employee1);
	}

	private static void createOps(Employee employeeObj, Session session) {
		session.save(employeeObj);
	}
}
