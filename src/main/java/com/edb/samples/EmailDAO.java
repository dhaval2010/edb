package com.edb.samples;


public class EmailDAO extends ApplicationDAOImpl<Email> {

	public boolean addEmail(Email email) throws ApplicationException {
		save(email);
		return true;
	}

	/*
	 * public void addEmail2(Email newEmail) throws ApplicationException {// EDB
	 * StringBuilder sb = new StringBuilder(); sb.append(
	 * "INSERT INTO EMAIL(EMAIL_ID,MAIL_CC,SEND_DT,EMAIL_IND,CONTENT,MAIL_FROM,MAIL_BCC,MAIL_TO,MAIL_REPLY_TO,SUBJECT)"
	 * ); sb.append(
	 * "values (:emailId,:mailCc,:sendDt,:emailInd,:content,:mailFrom,:mailBcc,:mailTo,:mailReplyTo,:subject)"
	 * ); Query query = em.createNativeQuery(sb.toString());
	 * query.setParameter("emailId", EmailId()); query.setParameter("mailCc",
	 * newEmail.getCc()); query.setParameter("sendDt", newEmail.getDateSent());
	 * query.setParameter("emailInd", newEmail.getEmailFlag());
	 * query.setParameter("content", newEmail.getMailBody());
	 * query.setParameter("mailFrom", newEmail.getMailFrom());
	 * query.setParameter("mailBcc", newEmail.getMailBcc());
	 * query.setParameter("mailTo", newEmail.getMailTo());
	 * query.setParameter("mailReplyTo", newEmail.getReplyTo());
	 * query.setParameter("subject", newEmail.getSubject());
	 * query.executeUpdate(); }
	 */
}