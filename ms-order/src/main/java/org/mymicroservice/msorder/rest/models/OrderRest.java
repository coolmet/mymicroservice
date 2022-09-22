package org.mymicroservice.msorder.rest.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderRest {
    @NotNull(message = "customer name null olamaz")
    @NotEmpty
    @Size(min = 2,max = 12)
    private String customerName;
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 12)
    private String customerNumber;
    @Valid
    private List<MealRest> meals;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<MealRest> getMeals() {
        return meals;
    }

    public void setMeals(List<MealRest> meals) {
        this.meals = meals;
    }
}
