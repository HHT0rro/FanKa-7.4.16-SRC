package com.alimm.tanx.core.ad.ad.splash;

import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.NotConfused;
import com.alipay.sdk.util.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RsDownloadStatus implements NotConfused {
    public static final int RS_STATUS_DELETED_EXPIRED = 3;
    public static final int RS_STATUS_DELETED_FULL = 4;
    public static final int RS_STATUS_DOWNLOADED = 2;
    public static final int RS_STATUS_DOWNLOAD_ERROR = 1;
    public static final int RS_STATUS_INIT = 0;
    public static final int RS_STATUS_UNKNOWN = -1;
    public final String mFileName;
    public int mStatus;

    public RsDownloadStatus(@NonNull String str, int i10) {
        this.mFileName = str;
        this.mStatus = i10;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i10) {
        this.mStatus = i10;
    }

    public String toString() {
        return "{RsDownloadStatus: name = " + this.mFileName + ",mStatus = " + this.mStatus + i.f4738d;
    }
}
