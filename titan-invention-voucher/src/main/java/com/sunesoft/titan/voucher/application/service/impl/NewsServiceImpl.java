package com.sunesoft.titan.voucher.application.service.impl;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.sqlBuilderTool.OrderType;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.common.utils.BeanUtil;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.voucher.application.cretirias.NewsCretiria;
import com.sunesoft.titan.voucher.application.dtos.NewsDto;
import com.sunesoft.titan.voucher.application.service.NewsService;
import com.sunesoft.titan.voucher.domain.News;
import com.sunesoft.titan.voucher.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/12/11
 */
@SuppressWarnings("all")
@Service
public class NewsServiceImpl extends GenericHibernateFinder implements NewsService {


    @Autowired
    NewsRepository newsRepository;

    @Override
    public TResult<NewsDto> getNewsById(UUID id) {
        News news = newsRepository.get(id);
        return new TResult(ConvertUtil.convert(news, NewsDto.class));
    }

    @Override
    public TResult addOrUpdateNews(NewsDto newsDto) {
        News news = null;
        if (newsDto.getId() != null) {
            news = newsRepository.get(newsDto.getId());
        } else {
            news = new News();
        }
        BeanUtil.copyPropertiesIgnoreNull(newsDto, news);
        news.setIssueTime(LocalDateTime.now());
        newsRepository.save(news);
        return new TResult(ConvertUtil.convert(news, NewsDto.class));
    }

    @Override
    public TResult deleteNews(UUID id) {
        newsRepository.delete(id);
        return new TResult(id);
    }

    @Override
    public PagedResult<NewsDto> getNewsPaged(NewsCretiria newsCretiria) {
        SqlBuilder<NewsDto> builder = HSqlBuilder.hFrom(News.class, "n")
                .where(newsCretiria.getParams())
                .orderBy("create_datetime", OrderType.DESC)
                .select(NewsDto.class)
                .pagging(newsCretiria.getPageIndex(),newsCretiria.getPageSize());
        return this.queryBySqlPaged(builder);
    }
}
