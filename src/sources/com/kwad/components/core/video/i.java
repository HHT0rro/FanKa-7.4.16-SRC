package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    private volatile boolean UT;
    private long UU;
    private a UV = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private long UW = 0;
        private int UX = 0;

        public final void accumulate(long j10) {
            this.UW += j10;
            this.UX++;
        }

        public final int rW() {
            return this.UX;
        }

        public final long rX() {
            return this.UW;
        }

        public final void reset() {
            this.UW = 0L;
            this.UX = 0;
        }
    }

    public final void rR() {
        if (this.UT) {
            return;
        }
        this.UT = true;
        this.UU = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.ev("videoStartBlock");
    }

    public final void rS() {
        if (this.UT) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.UU;
            this.UV.accumulate(elapsedRealtime);
            this.UT = false;
            com.kwad.sdk.core.video.a.a.a.ev("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.ev("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean rT() {
        return this.UT;
    }

    @NonNull
    public final a rU() {
        if (this.UT) {
            this.UV.accumulate(SystemClock.elapsedRealtime() - this.UU);
            this.UT = false;
        }
        return this.UV;
    }

    public final long rV() {
        return this.UU;
    }

    public final void reset() {
        this.UT = false;
        this.UU = 0L;
        this.UV.reset();
    }
}
