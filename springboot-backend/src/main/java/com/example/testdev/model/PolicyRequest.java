package com.example.testdev.model;

public class PolicyRequest {
    private HeaderDataRequest headerData;
    private RequestRecord requestRecord;

    public HeaderDataRequest getHeaderData() {
        return headerData;
    }

    public void setHeaderData(HeaderDataRequest headerData) {
        this.headerData = headerData;
    }

    public RequestRecord getRequestRecord() {
        return requestRecord;
    }

    public void setRequestRecord(RequestRecord requestRecord) {
        this.requestRecord = requestRecord;
    }
}
