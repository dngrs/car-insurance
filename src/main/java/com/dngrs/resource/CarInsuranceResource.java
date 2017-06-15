package com.dngrs.resource;

import com.dngrs.model.CarInsurance;
import com.dngrs.model.CarInsuranceRequest;
import com.dngrs.model.CarInsuranceResponse;
import com.dngrs.service.CarInsuranceService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Odokienko.
 */

@Path("/insurances")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarInsuranceResource {

    private CarInsuranceService carInsuranceService = new CarInsuranceService();

    @GET
    public Response getAllInsurances(){

        List<CarInsurance> carInsuranceList = carInsuranceService.getListOfAllInsurances();
        CarInsuranceResponse insuranceResponse = new CarInsuranceResponse();
        insuranceResponse.setCarInsuranceList(carInsuranceList);
        return Response.ok()
                .entity(insuranceResponse)
                .header("Content-Type", "application/json;charset=UTF-8")
                .build();

    }

    @POST
    public Response getInsuranceById(CarInsuranceRequest request){

        CarInsurance carInsurance = carInsuranceService.getInsuranceById(request.getId());
        CarInsuranceResponse carInsuranceResponse = new CarInsuranceResponse();
        if (carInsurance == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No insurance by such id")
                    .build();
        } else {
            List<CarInsurance> carInsuranceList = new ArrayList<>();
            carInsuranceList.add(carInsurance);
            carInsuranceResponse.setCarInsuranceList(carInsuranceList);
            return Response.ok()
                    .entity(carInsuranceResponse)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .build();
        }

    }

}
