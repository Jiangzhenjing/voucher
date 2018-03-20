package com.sunesoft.titan.voucher.controller.admin;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.NewsCretiria;
import com.sunesoft.titan.voucher.application.dtos.NewsDto;
import com.sunesoft.titan.voucher.application.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/voucher/admin/news")
public class NewsContriller {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list_view () {
        return "voucher/admin/news/list";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<NewsDto> list (NewsCretiria newsCretiria) {
        return newsService.getNewsPaged(newsCretiria);
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add_view (UUID id, Model model) {
        if (id != null) {
            TResult<NewsDto> newsById = newsService.getNewsById(id);
            if (newsById != null) {
                model.addAttribute("newsInfo", newsById.getResult());
            }
        }
        return "voucher/admin/news/form";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    public TResult add (NewsDto newsDto) {
        return newsService.addOrUpdateNews(newsDto);
    }

    @RequestMapping(value="del")
    @ResponseBody
    public TResult del (UUID id) {
        return newsService.deleteNews(id);
    }

}
