package com.bytedance.pangle.download;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i10, String str);

    void onProgress(long j10, long j11);

    void onStart();

    void onSuccess(String str, String str2, long j10);
}
