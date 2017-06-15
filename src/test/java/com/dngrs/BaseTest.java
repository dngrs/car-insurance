package com.dngrs;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.logging.Logger;

/**
 * Created by Igor Odokienko.
 */
public class BaseTest {
    public static final String TEST_URL = "http://localhost:8080/rest";
    public static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
    ClientConfig clientConfig;
    Client client;
    WebTarget target;


    @Before
    public void setUp() {

        clientConfig = new ClientConfig();
        clientConfig.register(new LoggingFilter(LOGGER, true));
        client = ClientBuilder.newClient(clientConfig);
        target = client.target(TEST_URL);

    }

}
