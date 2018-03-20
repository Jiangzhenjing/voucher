package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class NewsCretiria extends TCretiria {


    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        if(!StringUtil.isEmpty(title)){
            params.put("title", "%" + title + "%");
        }
        if(!StringUtil.isEmpty(content)){
            params.put("content", "%" + content + "%");
        }
        return params;
    }
}
