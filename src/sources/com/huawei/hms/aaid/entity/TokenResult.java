package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TokenResult extends Result {

    @Packed
    private String belongId;

    @Packed
    private String token = "";

    @Packed
    private int retCode = 0;

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setBelongId(String str) {
        this.belongId = str;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
