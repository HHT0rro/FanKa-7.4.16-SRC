package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static volatile boolean aGs;
    private static String aGt;
    private static List<String> aGu;
    private static List<String> aGv;
    private static volatile boolean aGw;
    private static volatile boolean aGx;

    public static boolean HO() {
        if (aGs) {
            return false;
        }
        try {
            return ((Printer) s.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e2);
            aGs = true;
            return false;
        }
    }

    public static boolean HP() {
        if (aGx) {
            return aGw;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.Du().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aGw = false;
            aGx = true;
            return aGw;
        }
    }

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aGu = aVar.aGQ;
        aGv = aVar.aGR;
    }

    public static boolean bA(boolean z10) {
        List<String> list = aGu;
        if (list != null && !list.isEmpty()) {
            return a(aGu, true);
        }
        return g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true);
    }

    public static boolean bB(boolean z10) {
        List<String> list = aGv;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aGv, false);
    }

    private static boolean g(String str, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z10);
    }

    private static boolean a(List<String> list, boolean z10) {
        if (aGs) {
            return false;
        }
        try {
            Printer printer = (Printer) s.getField(Looper.getMainLooper(), "mLogging");
            if (printer != null) {
                aGt = printer.getClass().getName();
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z10) {
                    f.fx(aGt);
                }
                Iterator<String> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.Du().decode(iterator2.next()));
                    com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            } else {
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer not hook");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e2);
            aGs = true;
        }
        return false;
    }
}
