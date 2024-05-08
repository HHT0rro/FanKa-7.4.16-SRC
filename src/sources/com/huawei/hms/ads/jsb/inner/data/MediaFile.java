package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class MediaFile {
    private long duration;
    private long fileSize;
    private int height;
    private String mime;
    private Float ratio;
    private String soundSwitch = "y";
    private String url;
    private int width;

    public MediaFile(com.huawei.openalliance.ad.beans.metadata.MediaFile mediaFile, long j10) {
        int i10;
        this.width = 0;
        this.height = 0;
        if (mediaFile != null) {
            this.mime = mediaFile.Code();
            this.url = mediaFile.B();
            this.fileSize = mediaFile.Z();
            this.width = mediaFile.V();
            this.height = mediaFile.I();
        }
        int i11 = this.width;
        if (i11 > 0 && (i10 = this.height) > 0) {
            this.ratio = Float.valueOf(i11 / i10);
        }
        this.duration = j10;
    }

    public int B() {
        return this.height;
    }

    public String C() {
        return this.mime;
    }

    public String Code() {
        return this.url;
    }

    public void Code(String str) {
        this.soundSwitch = str;
    }

    public String I() {
        return this.soundSwitch;
    }

    public long S() {
        return this.duration;
    }

    public long V() {
        return this.fileSize;
    }

    public int Z() {
        return this.width;
    }
}
