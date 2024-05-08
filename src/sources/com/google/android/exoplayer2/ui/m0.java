package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

/* compiled from: TimeBar.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface m0 {

    /* compiled from: TimeBar.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(m0 m0Var, long j10, boolean z10);

        void b(m0 m0Var, long j10);

        void c(m0 m0Var, long j10);
    }

    void a(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i10);

    void setBufferedPosition(long j10);

    void setDuration(long j10);

    void setEnabled(boolean z10);

    void setPosition(long j10);
}
