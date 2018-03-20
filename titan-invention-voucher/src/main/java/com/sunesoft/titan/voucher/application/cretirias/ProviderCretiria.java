package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.common.cretiria.TCretiria;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderCretiria extends TCretiria {

    /**
     * 主键id
     */
    private UUID id;

    /**
     * 服务商编号
     */
    private String pNo;

    /**
     * 服务商名称
     */
    private String corpName;

    /**
     * 年份
     */
    private Integer year;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        if (id != null) {
            params.put("id", id);
        }
        if (pNo != null) {
            params.put("pNo", pNo);
        }
        if (corpName != null) {
            params.put("corpName", "%" + corpName + "%");
        }
        if (year != null) {
            params.put("year", year);
        }
        return params;
    }
}
