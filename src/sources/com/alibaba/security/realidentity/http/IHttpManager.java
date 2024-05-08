package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.realidentity.http.model.HttpMethod;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IHttpManager {
    void asyncDownloadFile(Context context, String str, String str2, ProgressCallback progressCallback);

    void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback);

    void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback, boolean z10);

    void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback);

    void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback, boolean z10);

    RpHttpResponse syncRequest(Context context, String str, String str2);

    RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod);

    RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod, boolean z10);

    RpHttpResponse syncRequest(Context context, String str, String str2, boolean z10);
}
