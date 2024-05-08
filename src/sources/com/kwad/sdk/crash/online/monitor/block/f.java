package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    private static boolean EA() {
        int HS = HS();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).size();
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + HS);
        return size >= ((long) HS);
    }

    private static int HS() {
        com.kwad.sdk.crash.online.monitor.a.a HQ = e.HQ();
        if (HQ != null) {
            return HQ.aGV;
        }
        return 20;
    }

    public static /* synthetic */ boolean HT() {
        return EA();
    }

    public static void a(String str, long j10, long j11, String str2, String str3, boolean z10) {
        try {
            h(b(str, j10, j11, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j10, long j11, String str2, String str3) {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = fw(b.fu(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j11 == 0) {
            j11 = 2000;
        }
        return c(str, j10, j11, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j10, long j11, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j11;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aGA = str;
        if (j10 == 0) {
            j10 = System.currentTimeMillis();
        }
        aVar.aGy = j10;
        aVar.repeatCount = (int) (j11 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    private static String fw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(u.bD, "\\.") + "\n";
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains("\n")) {
                replaceAll = replaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
            return str;
        }
    }

    public static void fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (e.HR()) {
            d dVar = new d();
            dVar.aGG = str;
            dVar.aGI = a.HP();
            com.kwad.sdk.commercial.b.p(dVar);
        }
    }

    public static void fy(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aGI = a.HP();
            com.kwad.sdk.commercial.b.p(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", str);
    }

    private static void h(final String str, final boolean z10) {
        g.execute(new ay() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (TextUtils.isEmpty(String.this)) {
                    return;
                }
                if (!z10 && f.zF() != 1) {
                    BlockReportAction blockReportAction = new BlockReportAction(String.this);
                    com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                    final Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                    if (context == null) {
                        return;
                    }
                    com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).j(blockReportAction);
                    if (f.HT()) {
                        final List<com.kwad.sdk.core.report.e> EI = com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).EI();
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.kwad.sdk.core.report.e> iterator2 = EI.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(((BlockReportAction) iterator2.next()).msg);
                        }
                        h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onError(int i10, String str2) {
                                com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", "errorCode:" + i10 + " errorMsg:" + str2);
                            }

                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onSuccess() {
                                com.kwad.sdk.crash.online.monitor.block.report.a.bw(context).x(EI);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "report now :" + String.this);
                h.ah("perf-block", String.this);
            }
        });
    }

    public static /* synthetic */ int zF() {
        return HS();
    }
}
