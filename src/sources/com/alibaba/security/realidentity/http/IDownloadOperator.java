package com.alibaba.security.realidentity.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IDownloadOperator {
    void cancel();

    void pause();

    void registerDownloadCallback(DownloadProgressCallback downloadProgressCallback);

    void start();

    void unregisterDownloadCallback();
}
