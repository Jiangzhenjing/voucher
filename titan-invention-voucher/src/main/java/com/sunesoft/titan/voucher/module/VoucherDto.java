package com.sunesoft.titan.voucher.module;

import java.util.UUID;

public class VoucherDto {

    private String voucherno;
    private UUID id;

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
