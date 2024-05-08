package com.huawei.openalliance.ad.constant;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum bq {
    HTTP("http://"),
    HTTPS("https://"),
    FILE("file://"),
    CONTENT("content://"),
    ASSET("asset://"),
    RES("res://");

    public String S;

    bq(String str) {
        this.S = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
