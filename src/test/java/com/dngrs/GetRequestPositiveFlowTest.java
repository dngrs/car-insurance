package com.dngrs;

import com.dngrs.model.CarInsurance;
import com.dngrs.model.CarInsuranceResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by Igor Odokienko.
 */
public class GetRequestPositiveFlowTest extends BaseTest {

    public WebTarget queryURL;

    @Before
    public void initialize(){
        queryURL = target.path("/insurances");
    }

    @Test
    public void checkStatusCode(){
        Response response = queryURL.request()
                .get();
        Assert.assertTrue(response.getStatus() == 200);

    }

    @Test
    public void checkContentType(){
        String contentType = queryURL.request()
                .get()
                .getHeaderString("Content-Type");
        Assert.assertTrue(contentType.equals("application/json;charset=UTF-8"));
    }

    @Test
    public void checkOptionsRequest(){
        String allow = queryURL.request()
                .options()
                .getHeaderString("Allow");
        Assert.assertTrue(allow.equals("HEAD,POST,GET,OPTIONS"));
    }

    @Test
    public void checkNumberOfInsurancesInResponse(){
        CarInsuranceResponse carInsuranceResponse = queryURL.request()
                .get(CarInsuranceResponse.class);
        Assert.assertEquals(4, carInsuranceResponse.getCarInsuranceList().size());
    }

    @Test
    public void checkInsuranceData(){
        CarInsuranceResponse carInsuranceResponse = queryURL.request()
                .get(CarInsuranceResponse.class);
        CarInsurance carInsurance = carInsuranceResponse.getCarInsuranceList().get(0);
        Assert.assertTrue(carInsurance.getId() == 1);
        Assert.assertTrue(carInsurance.getName().equals("КАСКО"));
        Assert.assertTrue(carInsurance.getDescription().equals("Страхование транспорта от ущерба, хищения или угона"));
    }


}
