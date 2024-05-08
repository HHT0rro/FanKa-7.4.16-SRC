package com.huawei.hmf.orb.aidl.communicate;

import com.huawei.hmf.annotation.Packed;
import com.huawei.hmf.orb.IMessageEntity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResponseHeader implements IMessageEntity {

    @Packed
    public int statusCode;

    public ResponseHeader(int i10) {
        this.statusCode = i10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ResponseHeader() {
    }
}
