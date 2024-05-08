package com.huawei.openalliance.ad.media;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum e {
    END(-2),
    ERROR(-1),
    IDLE(0),
    INITIALIZED(1),
    PREPARING(2),
    PREPARED(3),
    PLAYING(4),
    PAUSED(5),
    PLAYBACK_COMPLETED(6);

    public int L;

    e(int i10) {
        this.L = i10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int Code() {
        return this.L;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "(" + this.L + ")";
    }
}
