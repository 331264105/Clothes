package com.didu.sql;

import com.didu.domain.Hypermarket;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/10/27.
 */
public class HypermarketSql {
    public String selectHypermarket(String property){
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("hypermarket h");
                if (property != null && property.length() > 0) {
                        WHERE("h.property=#{arg0}");
                }
                ORDER_BY("pai desc");
            }
        }.toString();
        return sql;
    }
}
