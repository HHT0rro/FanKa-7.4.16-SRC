package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsbCallBackData<T> {
    private String callBackName;
    private boolean complete;
    private T data;

    public JsbCallBackData(T t2, boolean z10, String str) {
        this.complete = z10;
        this.data = t2;
        this.callBackName = str;
    }

    public boolean Code() {
        return this.complete;
    }

    public String I() {
        return this.callBackName;
    }

    public T V() {
        return this.data;
    }
}
