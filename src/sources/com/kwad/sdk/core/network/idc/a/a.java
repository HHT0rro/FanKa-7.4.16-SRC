package com.kwad.sdk.core.network.idc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private final long awK;
    private volatile boolean awL = false;

    public a(long j10, boolean z10) {
        this.awK = j10;
    }

    public final boolean DY() {
        return this.awL;
    }

    public final long DZ() {
        return this.awK;
    }

    public final a bm(boolean z10) {
        this.awL = true;
        return this;
    }
}
