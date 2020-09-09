package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * 响应结果类型
 */
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
