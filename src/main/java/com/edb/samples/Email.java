package com.edb.samples;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the EMAIL database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "EMAIL")
@SequenceGenerator(name = "EMAIL_GEN", sequenceName = "EMAIL_ID_SEQ",allocationSize=1)
@NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
public class Email implements Serializable {	

	@Id	
	@GeneratedValue(generator = "EMAIL_GEN")
	@Column(name = "EMAIL_ID")
	private long emailNo;

	//@Size(max = 4000)
	/*@org.hibernate.validator.constraints.Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Id")*/
	 @Column(name = "MAIL_CC")
	private String cc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SEND_DT")
	private Date dateSent;


	@Column(name = "EMAIL_IND")
	private long emailFlag;

	@Lob
	@Column(name = "CONTENT")
	private String mailBody;
	
	//@Size(max = 100)
    //@Pattern(regexp = "^['_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Id")
	@Column(name = "MAIL_FROM")
	private String mailFrom;
	
	//@Size(max = 4000)
    ////@Pattern(regexp = "^['_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Id")
	@Column(name = "MAIL_BCC")
	private String mailBcc;
	
	//@NotNull
    //@Size(max = 4000)
    ////@Pattern(regexp = "^['_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Id")
    @Column(name = "MAIL_TO")
    private String mailTo;
	

	//@Size(max = 300)
    //@Pattern(regexp = "^['_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Id")
	@Column(name = "MAIL_REPLY_TO")
	private String replyTo;
	
	//@Size(max = 4000)
	 @Column(name = "SUBJECT")
	private String subject;


	public Email() {
	}

	public long getEmailNo() {
		return this.emailNo;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Date getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	

	public String getMailBody() {
		return this.mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getMailFrom() {
		return this.mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return this.mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getReplyTo() {
		return this.replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [emailNo=");
		builder.append(emailNo);
		builder.append(", cc=");
		builder.append(cc);
		builder.append(", dateSent=");
		builder.append(dateSent);
		builder.append(", emailFlag=");
		builder.append(emailFlag);
		builder.append(", mailBody=");
		builder.append(mailBody);
		builder.append(", mailFrom=");
		builder.append(mailFrom);
		builder.append(", mailTo=");
		builder.append(mailTo);
		builder.append(", replyTo=");
		builder.append(replyTo);
		builder.append(", subject=");
		builder.append(subject);
		builder.append("]");
		return builder.toString();
	}

	
	public void setEmailNo(long emailNo) {
		this.emailNo = emailNo;
	}

	public long getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(long emailFlag) {
		this.emailFlag = emailFlag;
	}

	public String getMailBcc()
	{
		return mailBcc;
	}

	public void setMailBcc(String mailBcc)
	{
		this.mailBcc = mailBcc;
	}

}