package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IBXWebview {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface IBXDownloadService {
        long startDownload(String str, String str2);
    }

    void bxDestroy();

    void bxLoadUrl(String str);

    void bxSetUp(Context context, IUrlVerifyCallback iUrlVerifyCallback, IBXDownloadService iBXDownloadService);
}
