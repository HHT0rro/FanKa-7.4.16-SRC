package com.alipay.sdk.protocol;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");


    /* renamed from: g, reason: collision with root package name */
    private String f4656g;

    a(String str) {
        this.f4656g = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f4656g)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
