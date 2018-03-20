package com.sunesoft.titan.voucher.application.service;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.NewsCretiria;
import com.sunesoft.titan.voucher.application.dtos.NewsDto;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/12/11
 */
public interface NewsService {


    TResult<NewsDto> getNewsById(UUID id);



    TResult addOrUpdateNews(NewsDto newsDto);


    TResult deleteNews(UUID id);


    PagedResult<NewsDto> getNewsPaged(NewsCretiria newsCretiria);

}
