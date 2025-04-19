package com.example.testdev.model;

public class PolicyResponse {
    private HeaderDataResponse headerData;
    private ResponseRecord responseRecord;
    private ResponseStataus responseStatus;

    public HeaderDataResponse getHeaderData() {
        return headerData;
    }

    public void setHeaderData(HeaderDataResponse headerData) {
        this.headerData = headerData;
    }

    public ResponseRecord getResponseRecord() {
        return responseRecord;
    }

    public void setResponseRecord(ResponseRecord responseRecord) {
        this.responseRecord = responseRecord;
    }

    public ResponseStataus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStataus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
