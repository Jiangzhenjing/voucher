package com.sunesoft.titan.voucher;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.result.TResult;

import java.util.UUID;

public class helper {

    public static Boolean isEqualRole (String rolename) {
        return rolename.equals(getUserRolename());
    }

    public static Boolean isAdmin () {
        return (isEqualRole("Admin") || isEqualRole("regionAdmin"));
    }

    public static String getUserRolename () {
        return UserContext.getUser().getRoleIds().get(0);
    }

    static TResult errorMsg;

    public static TResult getErrorMsg() {
        return new TResult(false, "非法操作");
    }

    public static UUID getUserId () {
        return UUID.fromString(UserContext.getUser().getOpen_id());
    }

    public static Boolean isProvider () {
        return isEqualRole("Provider");
    }

    public static String getUsername () {
        return UserContext.getUserName();
    }
}
