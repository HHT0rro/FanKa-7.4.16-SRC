package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Video {
    private int maxDuration;

    public Video() {
    }

    @com.huawei.openalliance.ad.annotations.b
    public Video(int i10) {
        this.maxDuration = i10;
    }

    public int Code() {
        return this.maxDuration;
    }

    public void Code(int i10) {
        this.maxDuration = i10;
    }
}
