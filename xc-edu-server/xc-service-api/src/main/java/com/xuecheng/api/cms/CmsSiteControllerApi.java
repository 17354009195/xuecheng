package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QuerySiteRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * cms站点查询Api
 */
@Api(value = "cms站点管理接口",description = "cms站点管理接口，提供站点的增、删、改、查")
public interface CmsSiteControllerApi {
    @ApiOperation("分页查询站点列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "size",value = "每页记录数",required = true,paramType = "path",dataType = "int")})
    public QueryResponseResult findList(int page, int size, QuerySiteRequest querySiteResult);
}
