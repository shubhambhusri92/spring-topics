package com.luv2.code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

	public AccountDao() {
		System.out.println("Creting Bean for AccountDao class");
	}

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY  WORK: ADDING AN ACCOUNT");
	}
}
