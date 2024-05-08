package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements s.a, s.b {
    private long adJ;
    private long adK;
    private long adL;
    private int adM;
    private int adN = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void N(long j10) {
        if (this.adN <= 0) {
            return;
        }
        boolean z10 = true;
        if (this.adJ != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.adJ;
            if (uptimeMillis >= this.adN || (this.adM == 0 && uptimeMillis > 0)) {
                int i10 = (int) ((j10 - this.adK) / uptimeMillis);
                this.adM = i10;
                this.adM = Math.max(0, i10);
            } else {
                z10 = false;
            }
        }
        if (z10) {
            this.adK = j10;
            this.adJ = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j10) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j11 = j10 - this.adL;
        this.adJ = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.adM = (int) j11;
        } else {
            this.adM = (int) (j11 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.adM;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.adM = 0;
        this.adJ = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j10) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.adL = j10;
    }
}
