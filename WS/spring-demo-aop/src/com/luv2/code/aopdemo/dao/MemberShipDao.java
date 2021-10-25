package com.luv2.code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDao {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY  WORK: ADDING A MEMBERSHIP ACCOUNT");
	}
}
