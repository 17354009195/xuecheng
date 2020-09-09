package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请求模型
 */
@Data
public class QuerySiteRequest extends RequestData {
    //站点id
    @ApiModelProperty("站点id")
    private String siteId;
    //站点名称
    @ApiModelProperty("站点名称")
    private String siteName;
    //站点域名
    @ApiModelProperty("站点域名")
    private String siteDomain;
    //站点端口
    @ApiModelProperty("站点端口")
    private String sitePort;
    //站点创建时间
    @ApiModelProperty("站点创建时间")
    private String siteCreateTime;
}
