package com.alibaba.security.realidentity.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface DownloadProgressCallback {
    void onFailed(String str);

    void onFinish(String str, String str2, String str3);

    void onProgress(String str, long j10, long j11);

    void onStart(String str);
}
