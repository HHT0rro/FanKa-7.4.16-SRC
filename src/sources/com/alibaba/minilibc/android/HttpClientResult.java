package com.alibaba.minilibc.android;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class HttpClientResult {
    public String mExceptionString;
    public int mResponseCode;
    public String mString;

    public HttpClientResult(String str, int i10) {
        this.mString = str;
        this.mResponseCode = i10;
    }

    public HttpClientResult(String str, int i10, Throwable th) {
        this.mString = str;
        this.mResponseCode = i10;
        if (th != null) {
            this.mExceptionString = th.toString();
        }
    }
}
