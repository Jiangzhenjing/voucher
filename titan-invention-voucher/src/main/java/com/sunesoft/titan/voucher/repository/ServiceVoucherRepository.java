package com.sunesoft.titan.voucher.repository;

import com.sunesoft.titan.hibernate.repository.GenericHibernateRepositoryForIEntity;
import com.sunesoft.titan.systemManager.domain.Role;
import com.sunesoft.titan.voucher.domain.ServiceVoucher;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
@Repository
public class ServiceVoucherRepository extends GenericHibernateRepositoryForIEntity<ServiceVoucher> {

    /**
     * 根据服务券编号获取服务券
     *
     * @param voucherNo
     * @return
     */
    public ServiceVoucher getByNo(String voucherNo) {
        String hql = "FROM ServiceVoucher where is_active=1";
        Map<String, Object> params = new HashMap<>();
        hql = hql + " and voucherNo=:voucherNo";
        params.put("voucherNo", voucherNo);
        List<ServiceVoucher> list = this.createQuery(hql, params).list();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

    /**
     * 根据服务券的企业ID获取服务券
     *
     * @param uuid
     * @return
     */
    public ServiceVoucher getByCompanyId(UUID uuid) {
        String hql = "select s FROM ServiceVoucher s join s.companyInfo c where s.is_active=1 ";
        Map<String, Object> params = new HashMap<>();
        hql = hql + " and c.id=:uuid";
        params.put("uuid", uuid);
        List<ServiceVoucher> list = this.createQuery(hql, params).list();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

}
