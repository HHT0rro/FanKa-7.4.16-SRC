package com.kwad.sdk.j;

import com.alibaba.security.common.track.model.TrackConstants;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static List<String> aJx;
    private static volatile boolean aJy;

    @KsJson
    /* renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0540a extends com.kwad.sdk.commercial.c.a {
        public List<b> aJz;

        public C0540a(List<b> list) {
            this.aJz = list;
        }
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long aJA;
        public long aJB;
        public long aJC;
        public String aJD;
        public String aJE;
        public String sdkVersion;
        public String stage;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c {
        private String aJD;
        private String aJE;
        private String sdkVersion;
        private String stage;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String a(c cVar) {
            return "exit&" + cVar.aJD + "&" + cVar.stage + "&" + cVar.aJE + "&" + cVar.sdkVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c gb(String str) {
            String[] split = str.split("&");
            c cVar = new c();
            cVar.aJD = split[1];
            cVar.stage = split[2];
            cVar.aJE = split[3];
            cVar.sdkVersion = split[4];
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String c(String str, String str2, String str3, String str4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("&");
            sb2.append(str2);
            sb2.append("&");
            sb2.append(str3);
            sb2.append("&");
            sb2.append(str4);
            sb2.append("&");
            k.zd();
            sb2.append(k.getSDKVersion());
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Jq() {
        List<b> Js = Js();
        if (!Js.isEmpty()) {
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "monitorInfoList:" + ((Object) Js));
            com.kwad.sdk.commercial.b.o(new C0540a(Js));
        }
        aJy = true;
        Jr();
    }

    private static void Jr() {
        List<String> list = aJx;
        if (list == null) {
            return;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            fZ(iterator2.next());
        }
        aJx.clear();
    }

    private static List<b> Js() {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> al = y.al(ServiceProvider.getContext(), "dynamic_monitor_info");
        if (al == null) {
            return arrayList;
        }
        for (String str : al.h()) {
            if (str.startsWith(TrackConstants.Method.ENTER)) {
                Object obj = al.get(str);
                long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                c gb2 = c.gb(str);
                String a10 = c.a(gb2);
                Object obj2 = al.get(a10);
                long longValue2 = longValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                long j10 = longValue2 > 0 ? longValue2 : 0L;
                b bVar = new b();
                bVar.aJA = longValue;
                bVar.aJB = j10;
                bVar.aJC = longValue2;
                bVar.aJD = gb2.aJD;
                bVar.stage = gb2.stage;
                bVar.aJE = gb2.aJE;
                bVar.sdkVersion = gb2.sdkVersion;
                arrayList.add(bVar);
                y.au("dynamic_monitor_info", str);
                y.au("dynamic_monitor_info", a10);
            }
        }
        return arrayList;
    }

    public static void ak(String str, String str2) {
        g(str, str2, "other");
    }

    public static void al(String str, String str2) {
        h(str, str2, "other");
    }

    private static void b(String str, String str2, String str3, String str4) {
        try {
            String c4 = c.c(str, str2, str3, str4);
            if (!aJy) {
                ga(c4);
            } else {
                fZ(c4);
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private static synchronized void fZ(String str) {
        synchronized (a.class) {
            long b4 = y.b("dynamic_monitor_info", str, 0L);
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + b4);
            y.a("dynamic_monitor_info", str, b4 + 1);
        }
    }

    public static void g(String str, String str2, String str3) {
        b(TrackConstants.Method.ENTER, str, str2, str3);
    }

    private static void ga(String str) {
        if (aJx == null) {
            aJx = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "saveToCache: " + str);
        aJx.add(str);
    }

    public static void h(String str, String str2, String str3) {
        b("exit", str, str2, str3);
    }

    public static void report() {
        g.schedule(new ay() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.Jq();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}
