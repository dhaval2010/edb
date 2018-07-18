package com.edb.samples.test;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class ArquillianContainer {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Deployment
	@OverProtocol("Servlet 3.0")
	public static Archive<?> createTestArchive3() {
		final File[] libs = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();

		WebArchive shrinkWrap = ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackages(true, "com.edb.samples")
				.addAsLibraries(libs)
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(new File("src/test/resources/web.xml"),
						"web.xml")
				.addAsWebInfResource(
						new File(
								"src/test/resources/jboss-deployment-structure.xml"),
						"jboss-deployment-structure.xml")
				.addAsWebInfResource(
						new File("src/main/webapp/WEB-INF/beans.xml"),
						"beans.xml")
				.addAsWebInfResource(
						new File("src/main/webapp/WEB-INF/jboss-web.xml"),
						"jboss-web.xml");
		return shrinkWrap;
	}
}
