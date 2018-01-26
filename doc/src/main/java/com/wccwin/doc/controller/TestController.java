package com.wccwin.doc.controller;

import com.wccwin.RespModel;
import com.wccwin.doc.service.safe.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends OperController{

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @GetMapping("/safe_test")
    public RespModel<Integer> test(){

        RespModel<Integer> safeTest = testService.test();
        //System.out.println(" --   > test() In method! ");

        logger.info(" --   > test() In method! ");
        return RespModel.success(safeTest.getData());
    }

}
