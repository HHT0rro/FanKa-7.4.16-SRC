package com.huawei.appgallery.agd.pageframe.api;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.DownloadStatus;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IPageCallback {
    void onAppExposure(@NonNull AgdExposureInfo agdExposureInfo);

    void onCardAction(@NonNull CardEventInfo cardEventInfo);

    void onStatusChange(@NonNull DownloadStatus downloadStatus);
}
