package com.kwad.components.core.n.a.d.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> Mw = new HashMap();

    public static void a(int i10, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Mw.put(Integer.valueOf(i10), new WeakReference<>(adResultData));
    }

    public static AdResultData at(int i10) {
        WeakReference<AdResultData> weakReference = Mw.get(Integer.valueOf(i10));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
