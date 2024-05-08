package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JosBaseResp implements IMessageEntity {

    @Packed
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }
}
