package com.kwad.components.ad.i;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements h.a {
    private static volatile b Hr;

    private b() {
    }

    public static b md() {
        if (Hr == null) {
            synchronized (b.class) {
                if (Hr == null) {
                    Hr = new b();
                }
            }
        }
        return Hr;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i10) {
        if ((fVar instanceof com.kwad.components.core.request.a) && i10 != e.avy.errorCode) {
            int i11 = 21004;
            SceneImpl scene = fVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i10 == e.avt.errorCode) {
                    i11 = 21001;
                } else if (i10 == e.avx.errorCode) {
                    i11 = 21003;
                } else if (i10 > 0 && i10 < 1000) {
                    i11 = 21002;
                }
                com.kwad.components.core.o.a.qi().a(posId, i11);
            }
        }
    }

    public final void init() {
        h.DN().a(this);
    }
}
