package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdStatusInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadStatus;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setDownloadFinishTime(long j10) {
        this.downloadFinishTime = j10;
    }

    public void setDownloadSize(long j10) {
        this.downloadSize = j10;
    }

    public void setDownloadStatus(int i10) {
        this.downloadStatus = i10;
    }

    public void setDownloadType(int i10) {
        this.downloadType = i10;
    }

    public void setLoadDataTime(long j10) {
        this.loadDataTime = j10;
    }

    public void setLoadFromCache(boolean z10) {
        this.loadFromCache = z10;
    }
}
