package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryTemplateRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * cms模板查询api
 */
@Api(value = "cms模板管理接口" ,description = "cms模板管理接口,提供模板的增、删、改、查")
public interface CmsTemplateControllerApi {

    @ApiOperation("分页查询模板列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "path",dataType = "int"),
    @ApiImplicitParam(name="size",value = "每页展示条数",required = true,paramType = "path",dataType = "int")})
    public QueryResponseResult findList(int page, int size, QueryTemplateRequest queryTemplateRequest);
}
