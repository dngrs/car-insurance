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
public class PostRequestPositiveFlowTest extends BaseTest {

    public WebTarget queryURL;

    @Before
    public void initialize(){
        queryURL = target.path("/insurances");
    }

    @Test
    public void checkStatusCode(){
        CarInsuranceRequest carInsuranceRequest = new CarInsuranceRequest();
        carInsuranceRequest.setId(1);
        Response response = queryURL.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(carInsuranceRequest, MediaType.APPLICATION_JSON));
        Assert.assertEquals(200, response.getStatus());
    }

    @Test
    public void checkResponse(){
        CarInsuranceRequest carInsuranceRequest = new CarInsuranceRequest();
        carInsuranceRequest.setId(1);
        CarInsuranceResponse carInsuranceResponse = queryURL.request()
                .post(Entity.entity(carInsuranceRequest, MediaType.APPLICATION_JSON), CarInsuranceResponse.class);
        CarInsurance carInsurance = carInsuranceResponse.getCarInsuranceList().get(0);
        Assert.assertTrue(carInsurance.getId() == 1);
        Assert.assertTrue(carInsurance.getName().equals("КАСКО"));
        Assert.assertTrue(carInsurance.getDescription().equals("Страхование транспорта от ущерба, хищения или угона"));
    }

}
