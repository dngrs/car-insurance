package com.dngrs;

import com.dngrs.model.CarInsurance;
import com.dngrs.model.CarInsuranceRequest;
import com.dngrs.model.CarInsuranceResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor Odokienko.
 */
public class PostRequestNegativeFlowTest extends BaseTest{

    public WebTarget queryURL;

    @Before
    public void initialize(){
        queryURL = target.path("/insurances");
    }

    @Test
    public void checkStatusCodeWhenAcceptTypeIsNotSupported(){
        CarInsuranceRequest carInsuranceRequest = new CarInsuranceRequest();
        carInsuranceRequest.setId(1);
        Response response = queryURL.request(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.entity(carInsuranceRequest, MediaType.APPLICATION_JSON));
        Assert.assertEquals(406, response.getStatus());
    }

    @Test
    public void checkStatusCodeWhenContentTypeIsNotSupported(){
        CarInsuranceRequest carInsuranceRequest = new CarInsuranceRequest();
        carInsuranceRequest.setId(1);
        Response response = queryURL.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(carInsuranceRequest, MediaType.APPLICATION_XML));
        Assert.assertEquals(415, response.getStatus());
    }

    @Test
    public void checkResponseWhenIdIsWrong(){
        CarInsuranceRequest carInsuranceRequest = new CarInsuranceRequest();
        carInsuranceRequest.setId(100);
        Response response = queryURL.request()
                .post(Entity.entity(carInsuranceRequest, MediaType.APPLICATION_JSON));
        String responseBody = response.readEntity(String.class);
        Assert.assertEquals(404, response.getStatus());
        Assert.assertTrue(responseBody.equals("No insurance by such id"));
    }

    @Test
    public void checkResponseWhenRequestHasBadFormat(){
        String requestBody = "{\"id\":10, \"wrongPatameter\":test}";
        Response response = queryURL.request()
                .post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));
        Assert.assertTrue(response.getStatus() == 400);
    }

}
