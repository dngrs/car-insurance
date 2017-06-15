package com.dngrs.service;

import com.dngrs.model.CarInsurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Igor Odokienko.
 */

public class CarInsuranceService {

    private Map<Long, CarInsurance> carInsuranceMap = new HashMap<>();

    public CarInsuranceService(){
        carInsuranceMap.put(1L, new CarInsurance(1L, "КАСКО", "Страхование транспорта от ущерба, хищения или угона"));
        carInsuranceMap.put(2L, new CarInsurance(2L, "ОСАГО", "Обязательноe страхования автогражданской ответственности"));
        carInsuranceMap.put(3L, new CarInsurance(3L, "ДСАГО", "Добровольное страхование автогражданской ответственности"));
        carInsuranceMap.put(4L, new CarInsurance(4L, "Зелёная карта", "Обязательного страхования гражданской ответственности при выезде за границу"));

    }

    public List<CarInsurance> getListOfAllInsurances(){
        return new ArrayList<>(carInsuranceMap.values());
    }


    public CarInsurance getInsuranceById(long id){
        for (CarInsurance carInsurance: carInsuranceMap.values()) {
            if(carInsurance.getId() == id){
                return carInsurance;
            }
        }
        return null;
    }

}
