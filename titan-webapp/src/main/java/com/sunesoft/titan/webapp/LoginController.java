package com.sunesoft.titan.webapp;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.WebUtil;
import com.sunesoft.titan.common.result.IResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.settings.web.WebSettingContext;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.voucher.application.dtos.SVUserDto;
import com.sunesoft.titan.voucher.application.service.SysAuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class LoginController {


    @Autowired
    private SysAuthService sysAuthService;

    @Autowired
    SysUserService sysUserService;

    //    @RequestMapping(value = "/")
//    public String  index(HttpServletRequest request, Model model){
//
//        if(UserContext.getUser()!=null) {
//            model.addAttribute("userInfo", JSON.toJSONString(UserContext.getUserName()));
//            return  "redirect:voucher/common/homepg";
//        }else{
//
//
//            return  "redirect:login";
//        }
//    }
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req, Model model) {
        String role = req.getParameter("role");
        if (StringUtil.isEmpty(role)) {
            return "redirect:/";

        }
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:" + WebSettingContext.getIndexPage();
        }
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名不存在！";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "密码错误！";
        } else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "登录失败次数过多，请稍后再试！";
        } else if (AuthenticationException.class.getName().equals(exceptionClassName)) {
            error = "身份验证失败！";
        } else if ("jCaptcha.error".equals(exceptionClassName)) {
            error = "验证码错误！";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("msg", error);
        if (req.getParameter("kickout") != null) {
            model.addAttribute("msg", "您的帐号在另一个地点登录，您已被踢出！");
        }
        if (req.getParameter("forceLogout") != null) {
            model.addAttribute("msg", "您已经被管理员强制退出，请重新登录！");
        }

        model.addAttribute("role", role);
        return "login/" + role;
    }

    @RequestMapping(value = "/signup")
    public String signUp() {
        return "login/signup";
    }

    /**
     * 找回密码
     *
     * @return
     */
    @RequestMapping(value = "/changepw", method = RequestMethod.GET)
    public String password_find_view() {
        return "login/changepw";
    }

    @RequestMapping(value = "/changepw", method = RequestMethod.POST)
    @ResponseBody
    public IResult password_find(HttpServletRequest request,String oldpassword, String newpassword) {
        UUID id = UserContext.getUser().getId();
        IResult iResult = sysUserService.changePassword(id, oldpassword, newpassword);
        if(iResult.getIs_success()){
            SecurityUtils.getSubject().logout();
        }
        return iResult;
    }

    /**
     * 企业注册
     * @return
     *
     */
    @RequestMapping(value = "/company/signup", method = RequestMethod.GET)
    public String signup_view () {
        return "voucher/company/signup";
    }

    @RequestMapping(value="/company/signup", method = RequestMethod.POST)
    @ResponseBody
    public TResult signup (SVUserDto dto) {
        dto.setRoleType("Company");
        return sysAuthService.AddOrUpdateUser(dto);
    }

    /**
     * 账号设置
     */
    @RequestMapping("account")
    public String account () {
        return "voucher/company/setting/account";
    }
}
