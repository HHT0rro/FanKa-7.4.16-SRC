package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.kwad.sdk.core.videocache.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static f aCC;

    public static f b(Context context, int i10, int i11) {
        f fVar = aCC;
        if (fVar != null) {
            return fVar;
        }
        f c4 = c(context, i10, i11);
        aCC = c4;
        return c4;
    }

    public static f bl(Context context) {
        return b(context, 0, 0);
    }

    private static f c(Context context, int i10, int i11) {
        return new f.a(context).as(HttpProxyCacheServer.Builder.DEFAULT_MAX_SIZE).ds(i10).dt(i11).Gr();
    }
}
