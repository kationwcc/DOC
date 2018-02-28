package com.wccwin.api.controller;

import com.wccwin.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends OperController{

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public RespModel<Integer> test(){

        logger.info(" --   > test() In method! ");
        return RespModel.success(999);
    }

}
