package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static List<String> aGC = null;
    private static List<String> aGD = null;
    private static int aGE = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aGC = new ArrayList();
        List<String> list = aVar.aGP;
        if (list != null && !list.isEmpty()) {
            aGC.addAll(aVar.aGP);
        } else {
            aGC.add("com.kwad");
            aGC.add("com.kwai");
            aGC.add("com.ksad");
            aGC.add("tkruntime");
            aGC.add("tachikoma");
            aGC.add("kuaishou");
        }
        aGE = aVar.aGU;
        aGD = new ArrayList();
        List<String> list2 = aVar.aGO;
        if (list2 != null && !list2.isEmpty()) {
            aGD.addAll(aVar.aGO);
            return;
        }
        aGD.add("android.");
        aGD.add("androidx.");
        aGD.add("org.");
        aGD.add("java.");
    }

    private static boolean fs(String str) {
        List<String> list = aGD;
        if (list == null) {
            return false;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ft(String str) {
        List<String> list = aGC;
        if (list == null) {
            return false;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    public static String fu(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.e.c.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z10 = false;
        int i10 = 0;
        for (String str2 : split) {
            if (z10 || !fs(str2)) {
                if (i10 >= aGE) {
                    return "";
                }
                if (ft(str2)) {
                    return str;
                }
                i10++;
                z10 = true;
            }
        }
        return "";
    }
}
