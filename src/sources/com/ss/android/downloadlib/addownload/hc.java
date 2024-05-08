package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface hc {
    hc dk(int i10, DownloadStatusChangeListener downloadStatusChangeListener);

    hc dk(Context context);

    hc dk(DownloadController downloadController);

    hc dk(DownloadEventConfig downloadEventConfig);

    hc dk(DownloadModel downloadModel);

    void dk(int i10);

    boolean dk();

    void e();

    long l();

    hc m(long j10);

    hc m(IDownloadButtonClickListener iDownloadButtonClickListener);

    hc m(OnItemClickListener onItemClickListener);

    hc m(String str);

    void m();

    void m(boolean z10);

    boolean m(int i10);
}
