package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {
    private static void Y(String str) {
        if (mw() && com.kwad.sdk.k.zd().ys()) {
            v.O(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        Y("使用缓存策略: " + eVar.mA());
    }

    public static boolean mw() {
        return false;
    }
}
