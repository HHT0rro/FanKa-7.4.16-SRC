package com.huawei.hms.support.api.entity.safetydetect.base;

import com.huawei.hms.core.aidl.annotation.Packed;
import e9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BaseResp {

    @Packed
    public String errorReason;

    @Packed
    public int rtnCode;

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setRtnCode(int i10) {
        this.rtnCode = i10;
    }

    public String toString() {
        StringBuilder b4 = a.b("rtnCode=");
        b4.append(getRtnCode());
        b4.append("|errorReason=");
        b4.append(getErrorReason());
        return b4.toString();
    }
}
