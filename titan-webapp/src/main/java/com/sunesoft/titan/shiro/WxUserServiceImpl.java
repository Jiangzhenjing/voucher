package com.sunesoft.titan.shiro;

import com.sunesoft.titan.user.Dtos.TitanUser;
import com.sunesoft.titan.weChat.service.WxUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/9/5
 */
@Service
public class WxUserServiceImpl implements WxUserService {
    @Override
    public TitanUser wxUserLogin(WxMpUser wxMpUser) {
        TitanUser user = new TitanUser();
        user.setId(UUID.fromString("590ae0e3-61d7-4ecf-be1c-8df4bb1f25f6"));
        user.setIs_locked(false);
        user.setUser_name(wxMpUser.getNickname());
        user.setPassword("c4d6f647513261f13111505facb02fa5");
        user.setSalt("0a8135fc704ad1271973423804320195");
        List<String> permission = new ArrayList<>();
        user.setOpen_id(wxMpUser.getOpenId());
        permission.add("/admin");
        user.setPermissions(permission);
        List<String> roleIds = new ArrayList<>();
        roleIds.add("590ae0e3-61d7-4ecf-be1c-8df4bb1f25f6");
        user.setRoleIds(roleIds);
        return user;
    }
}
