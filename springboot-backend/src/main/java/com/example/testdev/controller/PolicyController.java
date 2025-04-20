package com.example.testdev.controller;

import com.example.testdev.model.PolicyRequest;
import com.example.testdev.model.PolicyResponse;
import com.example.testdev.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/retrieve")
    public PolicyResponse retrievePolicy(@RequestBody PolicyRequest request) {
        return policyService.retrievePolicyInformation(request);
    }

}
