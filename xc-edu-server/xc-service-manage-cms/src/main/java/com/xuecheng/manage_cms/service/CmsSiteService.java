package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class CmsSiteService {

    @Autowired
    CmsSiteRepository cmsSiteRepository;

    /**
     * 站点列表分页查询
     * @param page
     * @param size
     * @param querySiteResult
     * @return
     */
    public QueryResponseResult findList(int page, int size, QuerySiteRequest querySiteResult){
        if(querySiteResult == null){
            querySiteResult = new QuerySiteRequest();
        }
        CmsSite cmsSite = new CmsSite();
        if(StringUtils.isNotEmpty(querySiteResult.getSiteDomain())){
            cmsSite.setSiteDomain(querySiteResult.getSiteDomain());
        }
        if(StringUtils.isNotEmpty(querySiteResult.getSiteName())){
            cmsSite.setSiteName(querySiteResult.getSiteName());
        }
        if(StringUtils.isNotEmpty(querySiteResult.getSiteId())){
            cmsSite.setSiteId(querySiteResult.getSiteId());
        }
        if(StringUtils.isNotEmpty(querySiteResult.getSitePort())){
            cmsSite.setSitePort(querySiteResult.getSitePort());
        }
        if(page <= 0){
            page = 1;
        }
        page = page - 1;
        if(size <= 0){
            size = 10;
        }
        Pageable pageable = new PageRequest(page, size);
        Example<CmsSite> example = Example.of(cmsSite,ExampleMatcher.matching().withMatcher("siteName",ExampleMatcher.GenericPropertyMatchers.contains()));
        Page<CmsSite> cmsSites = cmsSiteRepository.findAll(example, pageable);
        QueryResult<CmsSite> cmsSiteQueryResult = new QueryResult<>();
        cmsSiteQueryResult.setList(cmsSites.getContent());
        cmsSiteQueryResult.setTotal(cmsSites.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS,cmsSiteQueryResult);
    }
}
