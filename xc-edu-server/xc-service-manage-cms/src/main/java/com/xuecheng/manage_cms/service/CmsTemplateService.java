package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CmsTemplateService {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    /**
     * 分页条件查询模板列表
     *
     * @param page
     * @param size
     * @param queryTemplateRequest
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryTemplateRequest queryTemplateRequest) {
        CmsTemplate cmsTemplate = new CmsTemplate();
        if (queryTemplateRequest == null) {
            queryTemplateRequest = new QueryTemplateRequest();
        }
        if (StringUtils.isNotEmpty(queryTemplateRequest.getSiteId())) {
            cmsTemplate.setSiteId(queryTemplateRequest.getSiteId());
        }
        if (StringUtils.isNotEmpty(queryTemplateRequest.getTemplateName())) {
            cmsTemplate.setTemplateName(queryTemplateRequest.getTemplateName());
        }
        if (StringUtils.isNotEmpty(queryTemplateRequest.getTemplateParameter())) {
            cmsTemplate.setTemplateParameter(queryTemplateRequest.getTemplateParameter());
        }
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = new PageRequest(page, size);
        Example<CmsTemplate> example = Example.of(cmsTemplate, ExampleMatcher.matching().withMatcher("temPlateName", ExampleMatcher.GenericPropertyMatchers.contains()));
        Page<CmsTemplate> templates = cmsTemplateRepository.findAll(example, pageable);
        QueryResult<CmsTemplate> cmsTemplateQueryResult = new QueryResult<>();
        cmsTemplateQueryResult.setList(templates.getContent());
        cmsTemplateQueryResult.setTotal(templates.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, cmsTemplateQueryResult);
    }
}
