package com.wccwin.api.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wccwin.api.bean.resp.RespModel;
import com.wccwin.api.entity.TUser;
import com.wccwin.api.pub.BusinessException;
import com.wccwin.api.service.TUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Autowired
    private TUserService tUserService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        /*RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        try {

            String token = request.getHeader("token");

            if(StringUtils.isBlank(token)){
                throw BusinessException.error(10);
            }

            TUser user = tUserService.getTUserByToken(token);
            if(user == null){
                throw BusinessException.error(2);
            }
            if(user.getDeleted()){
                throw BusinessException.error(9);
            }
            request.setAttribute("uid",user.getId());
            logger.info("send request to ", request.getMethod(), request.getRequestURI());
        } catch (Exception e){
            e.printStackTrace();
            logger.info("send error to ", request.getMethod(), request.getRequestURI());
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            HttpServletResponse response = ctx.getResponse();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(RespModel.error(-1, null, e));
            } catch(Exception e2){
                e2.printStackTrace();
            } finally {
                if(out != null){
                    out.close();
                }
            }

        }
*/

        return null;
    }
}
