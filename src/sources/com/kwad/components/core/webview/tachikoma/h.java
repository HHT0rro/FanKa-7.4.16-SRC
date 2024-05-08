package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> YE = new ConcurrentHashMap();
    private Map<String, Integer> YF = new ConcurrentSkipListMap();
    private int YG = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final h YH = new h();
    }

    private static int aO(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void aR(int i10) {
        if (this.YG + i10 > com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asZ)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> iterator2 = this.YF.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<String, Integer> next = iterator2.next();
                arrayList.add(next.getKey());
                this.YG -= next.getValue().intValue();
                iterator2.remove();
                if (this.YG <= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asZ) - i10) {
                    break;
                }
            }
            Iterator<E> iterator22 = arrayList.iterator2();
            while (iterator22.hasNext()) {
                this.YE.remove((String) iterator22.next());
            }
        }
    }

    private void q(String str, String str2) {
        int aO = aO(str2);
        this.YG += aO;
        this.YF.put(str, Integer.valueOf(aO));
    }

    public static h sB() {
        return a.YH;
    }

    public final void b(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asZ) == 0) {
            return;
        }
        if (this.YE.containsKey(str)) {
            if (this.YE.get(str).containsKey(Integer.valueOf(i10))) {
                return;
            } else {
                this.YE.remove(str);
            }
        }
        aR(aO(str2));
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(i10), str2);
        this.YE.put(str, hashMap);
        q(str, str2);
    }

    public final String o(String str, int i10) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asZ) != 0 && this.YE.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.YE.get(str);
            if (hashMap.containsKey(Integer.valueOf(i10))) {
                return hashMap.get(Integer.valueOf(i10));
            }
        }
        return "";
    }
}
