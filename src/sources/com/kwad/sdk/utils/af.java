package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class af {
    private Map<String, com.kwad.sdk.core.webview.a> aPr;
    private Map<String, com.kwad.sdk.core.webview.c.c> aPs;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.aPr.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aPs.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a gA(String str) {
        return this.aPr.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c gB(String str) {
        return this.aPs.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> iterator2 = this.aPr.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().ok();
        }
        this.aPr.clear();
        this.aPs.clear();
    }
}
