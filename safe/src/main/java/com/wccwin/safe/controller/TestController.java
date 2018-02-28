package com.wccwin.safe.controller;

import com.wccwin.RespModel;
import com.wccwin.safe.ExecuteMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
