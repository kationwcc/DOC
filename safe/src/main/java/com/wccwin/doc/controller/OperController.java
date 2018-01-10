package com.wccwin.doc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class OperController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    protected Map session;

    protected ServletContext context;

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public Map getSession() {
        return this.session;
    }

    public ServletContext getContext() {
        return this.context;
    }

    public HashMap getParams(String... obj) {
        HashMap params = new HashMap();
        String key = "";
        String value = "";
        Enumeration e = this.getRequest().getParameterNames();
        if (obj != null && obj.length > 0 && !"null".equals(obj[0])) {
            Enumeration e1 = this.request.getAttributeNames();
            if (e1 != null) {
                while (e1.hasMoreElements()) {
                    key = (String) e1.nextElement();
                    value = String.valueOf(this.request.getAttribute(key));
                    if ("ISO-8859-1".equals(getEncoding(value))) {
                        try {
                            params.put(key, new String(value.getBytes("ISO-8859-1"), "UTF-8"));
                        } catch (Exception arg8) {
                            arg8.printStackTrace();
                        }
                    } else {
                        params.put(key, value);
                    }
                }
            }
        }

        while (e.hasMoreElements()) {
            key = (String) e.nextElement();
            value = this.getRequest().getParameter(key);
            if ("ISO-8859-1".equals(getEncoding(value))) {
                try {
                    params.put(key, new String(value.getBytes("ISO-8859-1"), "UTF-8"));
                } catch (UnsupportedEncodingException arg7) {
                    arg7.printStackTrace();
                }
            } else {
                params.put(key, value);
            }
        }

        return params;
    }

    public String getIpAddr() {
        return this.getIpAddr(this.request);
    }

    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }


    public static String getEncoding(String str) {
        String encode = "GB2312";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception arg5) {
            ;
        }

        encode = "ISO-8859-1";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception arg4) {
            ;
        }

        encode = "UTF-8";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception arg3) {
            ;
        }

        encode = "GBK";

        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception arg2) {
            ;
        }

        return "";
    }

}
