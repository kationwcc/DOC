package com.wccwin.doc.service.safe;

import com.wccwin.doc.bean.resp.RespModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="SAFE-SERVICE", fallback = com.wccwin.doc.service.safe.fallback.TestServiceFallback.class)
public interface TestService {

    @RequestMapping(value = "/safe/test/test", method = RequestMethod.GET)
    RespModel<Integer> test();



}
