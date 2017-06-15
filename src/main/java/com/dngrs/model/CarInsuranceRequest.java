package com.dngrs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Igor Odokienko.
 */

@XmlRootElement
public class CarInsuranceRequest {

    private long id;

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public long getId() {
        return id;
    }

}
