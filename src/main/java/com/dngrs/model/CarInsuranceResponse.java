package com.dngrs.model;

import java.util.List;

/**
 * Created by Igor Odokienko.
 */

public class CarInsuranceResponse {

    private List<CarInsurance> carInsuranceList;

    public List<CarInsurance> getCarInsuranceList() {
        return carInsuranceList;
    }

    public void setCarInsuranceList(List<CarInsurance> carInsuranceList) {
        this.carInsuranceList = carInsuranceList;
    }
}
