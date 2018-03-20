package com.sunesoft.titan.voucher.repository;

import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateRepositoryForIEntity;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.domain.Provider;
import com.sunesoft.titan.voucher.domain.ProviderEngineer;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
@Component
public class ProviderRepository extends GenericHibernateRepositoryForIEntity<Provider> {

    /**
     * 根据名称编号查询服务商（精确）
     */
    public List<Provider> queryProviderUnique(ProviderDto dto) {
        String hql = "FROM Provider p where p.is_active=1 ";
        Map<String, Object> params = new HashMap<>();
        if (!StringUtil.isEmpty(dto.getpNo()) && !StringUtil.isEmpty(dto.getCorpName())) {
            hql += " and (p.pNo =:pNo or p.corpName =:corpName)";
            params.put("pNo", dto.getpNo());
            params.put("corpName", dto.getCorpName());
        }
        List<Provider> list = this.createQuery(hql, params).list();
        return list;
    }


    /**
     * 根据userId查询服务商（精确）
     */
    public Provider queryProviderByUserId(UUID uuid) {
        String hql = "FROM Provider p where p.is_active=1 and p.userId =:userId ";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", uuid);
        List<Provider> list = this.createQuery(hql, params).list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 根据Dto产品名称查询(精确)
     */
    public List<ProviderProduct> queryByDto(ProviderProductDto dto) {
        String hql = "FROM ProviderProduct p where p.is_active=1  and p.productName=:productName";
        Map<String, Object> params = new HashMap<>();
        params.put("productName", dto.getProductName());
        List<ProviderProduct> list = this.createQuery(hql, params).list();
        return list;
    }

    /**
     * 根据产品id名称查询
     */
    public ProviderProduct queryById(UUID uuid) {
        String hql = "FROM ProviderProduct p where p.is_active=1  and p.id=:uuid";
        Map<String, Object> params = new HashMap<>();
        params.put("uuid", uuid);
        List<ProviderProduct> list = this.createQuery(hql, params).list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 根据编号及企业ID查询工程师（精确）
     */
    public List<ProviderEngineer> queryEngineerByDto(ProviderEngineerDto dto) {
        String hql = "select p FROM ProviderEngineer p join p.provider e where p.is_active=1";
        Map<String, Object> params = new HashMap<>();
        if (!StringUtil.isEmpty(dto.getEngineerNo())) {
            hql += " and p.engineerNo =:engineerNo";
            params.put("engineerNo", dto.getEngineerNo());
        }
        if (!StringUtil.isEmpty(dto.getProviderId())) {
            hql += " and e.id =:providerId";
            params.put("providerId", dto.getProviderId());
        }
        List<ProviderEngineer> list = this.createQuery(hql, params).list();
        return list;
    }

}
