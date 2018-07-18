Perform below steps for using the example:

1. Clone https://github.com/dhaval2010/edb.git  into your local
2. Make sure you have JBOSS EAP 6.4 server on your local
3. Add datasource in standalone.xml file as below:
           JBOSS_6.4\standalone\configuration\standalone.xml
          
           <datasources>
                <datasource jta="false" jndi-name="java:jboss/datasources/EDBDS" pool-name="EDBDS" enabled="true" use-ccm="false">
                    <connection-url>jdbc:edb://URL??</connection-url>
                    <driver-class>com.edb.Driver</driver-class>
                    <driver>edbJDBCDriver</driver>
                    <security>
                        <user-name>USER??</user-name>
                        <password>PWD??</password>
                    </security>
                    <validation>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                    </validation>
                    <statement>
                        <share-prepared-statements>false</share-prepared-statements>
                    </statement>
                </datasource>
                <drivers>
                   <driver name="edbJDBCDriver" module="com.edb.ojdbc">
                        <xa-datasource-class>com.edb.xa.PGXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
            </datasources>

      Ensure to update URL ,USER  and PWD.
4. Create below table in DB

	CREATE TABLE email
	(
		email_id numeric NOT NULL,
		mail_to character varying(4000) COLLATE pg_catalog."default",
		mail_from character varying(100) COLLATE pg_catalog."default",
		mail_cc character varying(4000) COLLATE pg_catalog."default",
		mail_reply_to character varying(300) COLLATE pg_catalog."default",
		subject character varying(4000) COLLATE pg_catalog."default",
		email_ind numeric(1,0),
		send_dt timestamp without time zone,
		content clob COLLATE pg_catalog."default",
		mail_bcc character varying(4000) COLLATE pg_catalog."default",
		CONSTRAINT email_pk PRIMARY KEY (email_id)
	)

	Create sequence as : EMAIL_ID_SEQ

5. Start the JBOSS server  (run standalone server i.e. bin/standalone.bat)

3. Go to root dir of project and exec below command:
   mvn clean test -Plocal-unit-testing -U
