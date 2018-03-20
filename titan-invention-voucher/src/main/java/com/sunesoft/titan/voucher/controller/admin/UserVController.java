package com.sunesoft.titan.voucher.controller.admin;

import com.sunesoft.titan.common.result.IResult;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.systemManager.domain.User;
import com.sunesoft.titan.voucher.application.cretirias.SVUserCretirias;
import com.sunesoft.titan.voucher.application.dtos.SVUserDto;
import com.sunesoft.titan.voucher.application.service.SysAuthService;
import net.sf.ehcache.Cache;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 用户管理
 */
@Controller
@RequestMapping("voucher/admin/user")
public class UserVController {

    @Autowired
    private SysAuthService sysAuthService;

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    EhCacheCacheManager springCacheManager;
    /**
     * 用户列表页面
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String search_view () {
        return "voucher/admin/user/list";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public PagedResult<SVUserDto> search (SVUserCretirias svUserCretirias) {
        return sysAuthService.getSvUser(svUserCretirias);
    }

    /**
     * 用户添加
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String add_vie (@RequestParam(required = false) UUID id) {
        return "voucher/admin/user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult add (SVUserDto svUserDto) {
        return sysAuthService.AddOrUpdateUser(svUserDto);
    }

    /**
     * 更改密码
     */
    @RequestMapping(value = "resetpw/{id}", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String resetpw_view (@PathVariable UUID id, Model model) {
        model.addAttribute("id", id);
        return "voucher/admin/user/resetpw";
    }

    @RequestMapping(value="resetpw", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public IResult resetpw (UUID id, String pw) {
        Cache cache = springCacheManager.getCacheManager().getCache("authenticationCache");
        User userById = sysUserService.getUserById(id);
        boolean remove = cache.remove(userById.getUser_name());
        if(remove){
            System.out.println("移除用户session:"+userById.getUser_name());
        }
        return sysUserService.setPassword(id, pw);
    }

    /**
     * 禁用
     * @param id
     * @return
     */
    @RequestMapping(value="delete", method = RequestMethod.POST)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    @ResponseBody
    public IResult deleteUser (UUID id) {
        return sysAuthService.deleteUser(id);
    }
}
