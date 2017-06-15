package com.dngrs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor Odokienko.
 */
public class GetRequestNegativeFlowTest extends BaseTest {

    public WebTarget queryURL;

    @Before
    public void initialize(){
        queryURL = target.path("/insurances");
    }

    @Test
    public void checkStatusCodeWhenAcceptTypeIsNotSupported(){
        Response response = queryURL.request(MediaType.APPLICATION_XML)
                .get();
        Assert.assertTrue(response.getStatus() == 406);
    }

    @Test
    public void checkStatusCodeWhenHttpMethodIsNotSupported(){
        Response response = queryURL.request()
                .delete();
        Assert.assertTrue(response.getStatus() == 405);
    }

    @Test
    public void checkStatusCodeWhenResourceIsWrong(){
        WebTarget queryURL = target.path("/wrongresource");
        Response response = queryURL.request()
                .get();
        Assert.assertTrue(response.getStatus() == 404);
    }

}
