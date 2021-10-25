package com.luv2.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2.code.aopdemo.dao.AccountDao;
import com.luv2.code.aopdemo.dao.MemberShipDao;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDao account = context.getBean(AccountDao.class);

		// get membership bean from container
		MemberShipDao theMembershipDao = context.getBean(MemberShipDao.class);

		// call the business method
		account.addAccount();

		// call the membership business method
		theMembershipDao.addAccount();

		// close the context
		context.close();
	}

}
