package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.h;

/* compiled from: TrackSelectionUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {
    public static h.a a(ExoTrackSelection exoTrackSelection) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (exoTrackSelection.b(i11, elapsedRealtime)) {
                i10++;
            }
        }
        return new h.a(1, 0, length, i10);
    }
}
