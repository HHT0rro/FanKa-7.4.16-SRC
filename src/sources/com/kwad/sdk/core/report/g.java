package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g extends b<n, f> {
    private static volatile boolean axA;
    private static volatile g axB;
    private static r<n, f> axC;

    private g() {
    }

    private static g EJ() {
        if (axB == null) {
            synchronized (g.class) {
                if (axB == null) {
                    axB = new g();
                }
            }
        }
        axB.checkInit();
        return axB;
    }

    private static boolean W(long j10) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.W(j10);
    }

    private void b(final n nVar, boolean z10) {
        if (nVar == null || !axA) {
            return;
        }
        if (!z10 && !W(nVar.actionType)) {
            axB.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: EK, reason: merged with bridge method [inline-methods] */
                public n EF() {
                    return nVar.EM();
                }
            });
        } else {
            axB.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: EK, reason: merged with bridge method [inline-methods] */
                public n EF() {
                    return nVar.EM();
                }
            });
        }
    }

    private synchronized void checkInit() {
        if (axA) {
            return;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            return;
        }
        int as = hVar.as(context);
        i(context, as);
        t.init(context);
        t.ES();
        com.kwad.sdk.core.e.c.d("BatchReporter", "cache type = " + as);
        if (as == 2) {
            a(q.bf(context));
        }
        axA = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public f w(List<n> list) {
        r<n, f> rVar = axC;
        if (rVar != null) {
            return rVar.ER();
        }
        String z10 = z(list);
        if (!TextUtils.isEmpty(z10)) {
            return new f(z10);
        }
        return new f(list);
    }

    private static String z(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).ayQ)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(",\"actionList\":[");
        Iterator<n> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().ayQ);
            sb2.append(',');
        }
        int length = sb2.length();
        sb2.replace(length - 1, length, "]");
        return sb2.toString();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public static void a2(@NonNull n nVar) {
        a(nVar, false);
    }

    public static void a(@NonNull n nVar, boolean z10) {
        EJ().b(nVar, z10);
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        u<n, f> EP;
        r<n, f> rVar = axC;
        return (rVar == null || (EP = rVar.EP()) == null) ? super.a(context, lVar, atomicInteger) : EP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = axC;
        if (rVar != null) {
            return rVar.EQ();
        }
        return (f) super.a((g) nVar);
    }
}
