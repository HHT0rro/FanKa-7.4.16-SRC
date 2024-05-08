package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bm {
    private long aQU;
    private long aQV;
    private boolean aQW;

    public bm() {
        reset();
    }

    private void reset() {
        this.aQU = 0L;
        this.aQV = -1L;
    }

    public final void No() {
        if (this.aQW && this.aQV < 0) {
            this.aQV = SystemClock.elapsedRealtime();
        }
    }

    public final void Np() {
        if (this.aQW && this.aQV > 0) {
            this.aQU += SystemClock.elapsedRealtime() - this.aQV;
            this.aQV = -1L;
        }
    }

    public final long Nq() {
        if (!this.aQW) {
            return 0L;
        }
        this.aQW = false;
        if (this.aQV > 0) {
            this.aQU += SystemClock.elapsedRealtime() - this.aQV;
            this.aQV = -1L;
        }
        return this.aQU;
    }

    public final long getTime() {
        if (this.aQV > 0) {
            return (this.aQU + SystemClock.elapsedRealtime()) - this.aQV;
        }
        return this.aQU;
    }

    public final void startTiming() {
        reset();
        this.aQW = true;
        this.aQV = SystemClock.elapsedRealtime();
    }
}
