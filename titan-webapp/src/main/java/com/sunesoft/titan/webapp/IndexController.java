package com.sunesoft.titan.webapp;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.Constants;
import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.user.Dtos.TitanUser;
import com.sunesoft.titan.voucher.application.cretirias.NewsCretiria;
import com.sunesoft.titan.voucher.application.dtos.NewsDto;
import com.sunesoft.titan.voucher.application.service.NewsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/9/5
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private NewsService newsService;


    @RequestMapping(value = "")
    public String index(HttpServletRequest request, Model model) {
        NewsCretiria newsCretiria = new NewsCretiria();
        newsCretiria.setPageSize(3);
        PagedResult<NewsDto> newsPaged = newsService.getNewsPaged(newsCretiria);
        if (newsPaged != null) {
            model.addAttribute("news", newsPaged.getResult());
        }
        model.addAttribute("userInfo", JSON.toJSONString(UserContext.getUserName()));
        return "index";
    }

    @RequestMapping(value = "addorupdate")
    public String form() {
        return "voucher/index/form";
    }

    /**
     * 登录过后的跳转
     *
     * @return
     */
    @RequestMapping(value = "index")
    public String redirect() {
        TitanUser user = UserContext.getUser();

        if (user == null) {
            return "redirect:/";
        }
        String role = user.getRoleIds().get(0);
        if (role == null) {
            return "redirect:/";
        }
        if ("Admin".equals(role) || "regionAdmin".equals(role)) {
            return "redirect:/voucher/search";
        }
        if ("Provider".equals(role)) {
            return "redirect:/voucher/provider";
        }

        return "redirect:/voucher/company";
    }

    @RequestMapping(value = "news")
    public void news(Model model) {
        NewsCretiria newsCretiria = new NewsCretiria();
        PagedResult<NewsDto> newsPaged = newsService.getNewsPaged(newsCretiria);
        if (newsPaged != null) {
            model.addAttribute("news", newsPaged.getResult());
        }
    }

    @RequestMapping(value = "news/{id}")
    public String news_detail(@PathVariable UUID id, Model model) {
        TResult<NewsDto> newsById = newsService.getNewsById(id);
        if (newsById != null) {
            model.addAttribute("newInfo", newsById.getResult());
        }
        return "newInfo";
    }

    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping("sessionlist")
    @ResponseBody
    public Map<String,Object>  list(Model model) {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        Map<String,Object> maps = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("sessions", sessions);
        for (Session session : sessions) {
            if(session.getAttribute("user")!=null){
                maps.put(session.getId().toString(),session.getAttribute("user"));
            }
        }
        model.addAttribute("sesessionCount", sessions.size());
        return maps;
    }

    @RequestMapping("/{sessionId}/forceLogout")
    @ResponseBody
    public String forceLogout(@PathVariable("sessionId") String sessionId,
                              RedirectAttributes redirectAttributes) {
        try {
            Session session = sessionDAO.readSession(sessionId);
            if (session != null) {
                session.setAttribute(
                        Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);
            }
        } catch (Exception e) {/*ignore*/}

        return "退出成功";
    }

}
