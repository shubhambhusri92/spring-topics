package com.trasaction.transaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trasaction.transaction.model.Product;
import com.trasaction.transaction.model.Student;

@Transactional
@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	// persist() -- for saving to database
	// till the method completes transaction will not commit to db if saveStudent
	// fails whole transaction gets rolled back
	public void addProduct(String productName) {
		Product product = new Product();
		product.setName(productName);
		entityManager.persist(product);
		saveStudent();
	}

	private void saveStudent() {
		Student student = new Student();
		student.setUniversity("DBIT");
		entityManager.persist(student);
	}

	// find() -- for fetching from db
	public Product findProduct() {
		Product find = entityManager.find(Product.class, 1);
		return find;
	}

	// remove () -- for removing an entity
	public void removeProduct() {
		// Session unwrap = entityManager.unwrap(Session.class);
		entityManager.remove(entityManager.find(Product.class, 1));
	}

	// merge , detach and clear example
	public void mergeDetachAndClear() {
		Product product = entityManager.find(Product.class, 1);
		printManagedEntities(product); // Entity exists : Product [id=1, name=PumaNew]
		entityManager.detach(product);
		printManagedEntities(product);// Entity detached
		printManagedEntities(new Student());// Entity detached
		Product merge = entityManager.merge(product); // select query from product table
		printManagedEntities(merge); // Product [id=1, name=PumaNew]
		merge.setName("UCB");
		printManagedEntities(merge); // Product [id=1, name=UCB] replaced by updated one
		Student stud = new Student();
		printManagedEntities(stud);
		entityManager.clear();
		printManagedEntities(merge);
	}

	private void printManagedEntities(Object entity) {
		if (entityManager.contains(entity))
			System.out.println("Entity exists : " + entity);

		else
			System.out.println("Entity detached");
	}

	// refresh
	public void refreshAndFlush() {
		Product product = entityManager.find(Product.class, 1);
		product.setName("test");
		entityManager.flush(); // flush will flush the changes to DB
		entityManager.refresh(product);

	}

	// find and getReference
	public void getData() {
		Product find = entityManager.getReference(Product.class, 1); // this loads the proxy instance
		System.out.println(find);
	}
}
