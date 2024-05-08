package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: SystemClock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d0 implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void c() {
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public HandlerWrapper d(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
