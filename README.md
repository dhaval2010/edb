Perform below steps for using the example:

1. Clone this repo/branch
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

3. Go to root dir of this project and exec below command:
   mvn clean test -Plocal-unit-testing -U
   
   
