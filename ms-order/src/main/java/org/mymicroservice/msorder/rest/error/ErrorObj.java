package org.mymicroservice.msorder.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String microservice;
    private String desc;
    private Integer code;

    public ErrorObj() {
    }

    public ErrorObj(List<ErrorObj> subErrors, String microservice, String desc, Integer code) {
        this.subErrors = subErrors;
        this.microservice = microservice;
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public ErrorObj setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ErrorObj setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMicroservice() {
        return microservice;
    }

    public ErrorObj setMicroservice(String microservice) {
        this.microservice = microservice;
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
    }

    public ErrorObj addError(ErrorObj errorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(errorObj);
        return this;
    }

    public static void main(String[] args) {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setDesc("Error1");

        // extra bir code
        errorObj.setCode(100);
        errorObj.setMicroservice("domain1.sub1.order");


        ErrorObj errorObj2 = new ErrorObj().setDesc("error1")
                .setCode(100)
                .setMicroservice("domain1.sub1.order")
                .addError(new ErrorObj().setDesc("error2")
                        .setCode(100)
                        .setMicroservice("domain1.sub1.order1"))
                .addError(new ErrorObj().setDesc("error3")
                        .setCode(100)
                        .setMicroservice("domain1.sub1.order2"));
    }
}
