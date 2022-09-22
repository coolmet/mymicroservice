package org.mymicroservice.msorder.rest.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class MealRest {
    @NotEmpty
    private String name;
    @DecimalMax("10.0")
    @DecimalMin("0.5")
    private Float amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
