package com.huawei.quickcard.base.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static boolean a(CardHttpResponse cardHttpResponse) {
        return cardHttpResponse.getCode() >= 200 && cardHttpResponse.getCode() < 300;
    }
}
