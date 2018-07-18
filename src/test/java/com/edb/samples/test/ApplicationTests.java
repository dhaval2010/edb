package com.edb.samples.test;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.edb.samples.Email;
import com.edb.samples.EmailManager;

@RunWith(Arquillian.class)
public class ApplicationTests extends ArquillianContainer {

	@Inject
	public EmailManager manager;
	
	@Test
	@Transactional(TransactionMode.COMMIT)
	public void clobObjectsNotGettingStored()
	{
		Email email = new Email();
		email.setCc("test@test.com");
		email.setDateSent(new Date());
		email.setMailBody("Test");
		email.setMailFrom("test@test.com");
		email.setSubject("Test");
		Assert.assertTrue(manager.addEmail(email));
	}
	
}