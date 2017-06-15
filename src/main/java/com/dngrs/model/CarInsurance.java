package com.dngrs.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Igor Odokienko.
 */
@XmlRootElement
@XmlType(propOrder={"id", "name", "description"})
public class CarInsurance {

    private long id;
    private String name;
    private String description;

    public CarInsurance() {
    }

    public CarInsurance(long id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
