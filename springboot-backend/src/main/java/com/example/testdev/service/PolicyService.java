package com.example.testdev.service;

import com.example.testdev.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PolicyService {

    public PolicyResponse retrievePolicyInformation(PolicyRequest request) {
        // Mocking the response for demonstration purposes
        PolicyResponse response = new PolicyResponse();

        // Create a mock header data
        HeaderDataResponse headerData = new HeaderDataResponse();
        headerData.setMessageId(request.getHeaderData().getMessageId());
        headerData.setSendDateTime(request.getHeaderData().getSendDateTime());
        headerData.setResponseDateTime(getCurrentDateTime());
        response.setHeaderData(headerData);

        // Create a mock response record
        ResponseRecord record = new ResponseRecord();
        if ("นายA1".equals(request.getRequestRecord().getInsureName())) {
            record.setPolicyNo("P00031");
            record.setPolicyType("CL");
            record.setStatus("A");
            record.setAgenID("00000005");

            // Create a list of array
            Policy policyDetail = new Policy();
            policyDetail.setPolicyNo("P00031");
            policyDetail.setStatus("A");
            policyDetail.setAgenID("00000005");

            Policy[] policies = {policyDetail};
            record.setPolicy(policies);

            response.setResponseRecord(record);

            // Create a mock response status
            ResponseStatus status = new ResponseStatus();
            status.setStatus("S");
            status.setErrorCode("");
            status.setErrorMessage("");
            response.setResponseStatus(status);
        } else {
            // No policy found
            ResponseStatus status = new ResponseStatus();
            status.setStatus("E");
            status.setErrorCode("404");
            status.setErrorMessage("No policy found for the given insured name.");
            response.setResponseStatus(status);
        }

        return response;
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

}
