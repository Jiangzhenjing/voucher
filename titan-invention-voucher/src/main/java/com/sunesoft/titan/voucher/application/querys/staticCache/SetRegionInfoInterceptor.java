package com.sunesoft.titan.voucher.application.querys.staticCache;

import com.sunesoft.titan.UserUtil;
import com.sunesoft.titan.interceptor.OnceAbstractInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */
public class SetRegionInfoInterceptor extends OnceAbstractInterceptor {
    protected static String login = "/login";

    public SetRegionInfoInterceptor() {
    }

    public boolean preOnce(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("regions",StaticRegionInfo.getRegionInfos());
        return  true;

    }


}
