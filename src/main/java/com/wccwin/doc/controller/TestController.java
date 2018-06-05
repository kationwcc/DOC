package com.wccwin.doc.controller;

import com.wccwin.doc.bean.resp.RespModel;
import com.wccwin.doc.service.safe.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService testService;


    @GetMapping("/safe_test")
    public RespModel<Integer> test(){

        RespModel<Integer> safeTest = testService.test();
        System.out.println(" --   > test() In method! ");

        return safeTest;
    }

}
