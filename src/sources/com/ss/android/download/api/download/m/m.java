package com.ss.android.download.api.download.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface m {
    void dk(@Nullable DownloadInfo downloadInfo, String str);

    void m(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void m(@NonNull DownloadInfo downloadInfo);

    void m(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void m(@NonNull DownloadInfo downloadInfo, String str);
}
