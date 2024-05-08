package com.huawei.appgallery.agd.core.api;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Video extends JsonBean implements Serializable {
    private static final long serialVersionUID = 6358683940666061213L;

    @NetworkTransmission
    private int coverHeight;

    @NetworkTransmission
    private String coverUrl;

    @NetworkTransmission
    private int coverWidth;

    @NetworkTransmission
    private long duration;

    @NetworkTransmission
    private float ration;

    @NetworkTransmission
    private String sha256;

    @NetworkTransmission
    private long size;

    @NetworkTransmission
    private String url;

    public float getAspectRatio() {
        return this.ration;
    }

    public int getCoverHeight() {
        return this.coverHeight;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getCoverWidth() {
        return this.coverWidth;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getSha256() {
        return this.sha256;
    }

    public long getSize() {
        return this.size;
    }

    public Uri getUri() {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        return Uri.parse(this.url);
    }

    public void setCoverHeight(int i10) {
        this.coverHeight = i10;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCoverWidth(int i10) {
        this.coverWidth = i10;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setRation(float f10) {
        this.ration = f10;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
