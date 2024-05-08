package com.alimm.tanx.core.net.okhttp.callback;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnDownloadListener {
    void onDownLoadTotal(long j10);

    void onDownloadFailed(int i10, String str);

    void onDownloadSuccess(File file);

    void onDownloading(int i10);
}
