package com.hailiang.advlib.core;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IAppDownloadListener {
    void onDownloadActive(long j10, long j11, String str);

    void onDownloadCompleted(String str);

    void onDownloadFailed();

    void onDownloadPaused(long j10, long j11, String str);

    void onIdle();

    void onInstalled(String str);
}
