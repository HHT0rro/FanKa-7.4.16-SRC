package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static boolean TL = false;
    private static AtomicBoolean aBq = null;
    private static int aBr = -1;
    private static final AtomicBoolean aBs = new AtomicBoolean(false);
    private static final AtomicBoolean aBt = new AtomicBoolean(false);
    private static int aBu;

    private static boolean Ax() {
        return aBt.get() || com.kwad.framework.a.a.Iv.booleanValue();
    }

    public static int Gf() {
        return aBu;
    }

    private static boolean Gg() {
        AtomicBoolean atomicBoolean = aBq;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aBq = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z10, boolean z11, boolean z12, int i10) {
        boolean z13;
        b bVar;
        b bVar2;
        try {
            if (Ax() && z11 && Gg()) {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i10);
                aBu = 2;
                dVar.bn(z10);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aBu = 1;
                bVar2 = bVar3;
            }
            z13 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!TL) {
                TL = true;
                com.kwad.sdk.service.c.gatherException(th);
            }
            b bVar4 = new b();
            aBu = 1;
            z13 = true;
            bVar = bVar4;
        }
        int a10 = an.a(Ax(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp(), z11, Gg(), z13, z12, bVar.getMediaPlayerType());
        com.kwad.sdk.core.e.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a10));
        if (aBr != a10) {
            aBr = a10;
            dq(a10);
        }
        return bVar;
    }

    private static void dq(int i10) {
        n nVar = new n(10212L);
        nVar.ayp = i10;
        g.a2(nVar);
    }
}
