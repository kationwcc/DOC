package com.wccwin.safe.controller;


import com.wccwin.safe.bean.resp.RespModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public RespModel<Integer> test(){

        System.out.println(" --   > test() In method! ");
        return RespModel.success(999);
    }

}
