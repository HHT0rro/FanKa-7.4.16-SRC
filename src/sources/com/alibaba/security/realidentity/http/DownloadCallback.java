package com.alibaba.security.realidentity.http;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface DownloadCallback {
    void onComplete(HashMap<String, String> hashMap);

    void onError();

    void onProgress(int i10);

    void onStart();
}
