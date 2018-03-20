package com.sunesoft.titan.voucher.repository;

import com.sunesoft.titan.hibernate.repository.GenericHibernateRepositoryForIEntity;
import com.sunesoft.titan.voucher.domain.CompanyInfo;
import com.sunesoft.titan.voucher.domain.ServiceVoucher;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
@Repository
public class CompanyInfoRepository extends GenericHibernateRepositoryForIEntity<CompanyInfo> {

    public CompanyInfo getByNo(String phoneNo) {
        String hql = "FROM CompanyInfo where is_active=1";
        Map<String, Object> params = new HashMap<>();
        hql = hql + " and phoneNo=:phoneNo";
        params.put("phoneNo", phoneNo);
        List<CompanyInfo> list = this.createQuery(hql, params).list();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }
}
