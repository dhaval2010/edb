package com.edb.samples;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmailManager {

	@Inject
	public EmailDAO dao;

	public boolean addEmail(Email email) {
		try {
			dao.addEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
