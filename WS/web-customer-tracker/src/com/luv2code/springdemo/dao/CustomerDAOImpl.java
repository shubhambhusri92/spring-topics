package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject Hibernate Session Factory
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session session = sessionfactory.getCurrentSession();

		// create the query--- and sort by last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// get the result from query by executing
		List<Customer> result = query.getResultList();

		// return the result
		return result;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionfactory.getCurrentSession();

		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(Customer.class, theId);
	}

	@Override
	public void deleteById(int theId) {
		Session session = sessionfactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		// here we can also delete by building a query or by directly calling
		// session.delete
		/*
		 * Query query = session.createQuery("delete from Customer where id=:theId");
		 * query.setParameter("theId", theId); query.executeUpdate();
		 */
		session.delete(customer);
	}

}
