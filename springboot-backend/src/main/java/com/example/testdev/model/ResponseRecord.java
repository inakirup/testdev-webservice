package com.example.testdev.model;

public class ResponseRecord {
    private Policy[] policy;
    private String policyNo;
    private String policyType;
    private String status;
    private String agenID;

    public Policy[] getPolicy() {
        return policy;
    }

    public void setPolicy(Policy[] policy) {
        this.policy = policy;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgenID() {
        return agenID;
    }

    public void setAgenID(String agenID) {
        this.agenID = agenID;
    }
}
