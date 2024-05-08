package com.jd.ad.sdk.jad_zi;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_kx {

    @Nullable
    public static jad_jw jad_an;
    public static long jad_bo;

    public static jad_jw jad_an() {
        synchronized (jad_kx.class) {
            jad_jw jad_jwVar = jad_an;
            if (jad_jwVar == null) {
                return new jad_jw();
            }
            jad_an = jad_jwVar.jad_fs;
            jad_jwVar.jad_fs = null;
            jad_bo -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return jad_jwVar;
        }
    }

    public static void jad_an(jad_jw jad_jwVar) {
        if (jad_jwVar.jad_fs != null || jad_jwVar.jad_jt != null) {
            throw new IllegalArgumentException();
        }
        if (jad_jwVar.jad_dq) {
            return;
        }
        synchronized (jad_kx.class) {
            long j10 = jad_bo + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            if (j10 > 65536) {
                return;
            }
            jad_bo = j10;
            jad_jwVar.jad_fs = jad_an;
            jad_jwVar.jad_cp = 0;
            jad_jwVar.jad_bo = 0;
            jad_an = jad_jwVar;
        }
    }
}
