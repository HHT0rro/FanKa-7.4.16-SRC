package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static AdHttpProxy awt;

    /* renamed from: com.kwad.sdk.core.network.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0527a {
        public String msg;
    }

    private static boolean DR() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.yP();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0527a c0527a, long j10, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy aVar;
        boolean DR = DR();
        AdHttpProxy adHttpProxy = awt;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "isAdCacheEnable:" + DR);
            if (DR) {
                aVar = f.xT();
            } else {
                aVar = new com.kwad.sdk.core.network.c.a();
            }
            adHttpProxy = aVar;
            awt = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.f36636md.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j10 + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j10, adHttpResponseListener);
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", Log.getStackTraceString(e2));
            c0527a.msg = e2.getMessage();
            return false;
        }
    }
}
