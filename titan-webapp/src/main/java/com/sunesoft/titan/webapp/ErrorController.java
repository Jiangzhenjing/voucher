package com.sunesoft.titan.webapp;

import com.sunesoft.titan.annotations.UnCheckPermission;
import com.sunesoft.titan.settings.web.WebSettingContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Zhouzh
 * @Date: 2017/8/25
 */
@UnCheckPermission
@Controller
public class ErrorController {
    @RequestMapping(value="/404")
    public String notFound(){
        //do something
        return WebSettingContext.getPage404();
    }

    @RequestMapping(value="/wx500")
    public String InnerError(){
        //do something
        return WebSettingContext.getPage500();
    }

    @RequestMapping(value="/unauthorized")
    public String unAuthorized(){
        //do something
        return WebSettingContext.getUnauthorizedPage();
    }

}
