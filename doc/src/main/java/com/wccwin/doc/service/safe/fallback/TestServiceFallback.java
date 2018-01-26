package com.wccwin.doc.service.safe.fallback;

import com.wccwin.RespModel;
import com.wccwin.doc.service.safe.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceFallback implements TestService {

    @Override
    public RespModel<Integer> test() {
        return RespModel.error(-1, null, new Exception("safe-Service connection lose"));
    }
}
