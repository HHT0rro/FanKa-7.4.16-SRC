package com.huawei.secure.android.common.webview;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface WebViewLoadCallBack {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum ErrorCode {
        HTTP_URL,
        URL_NOT_IN_WHITE_LIST,
        OTHER
    }

    void a(String str, ErrorCode errorCode);
}
