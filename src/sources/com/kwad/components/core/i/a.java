package com.kwad.components.core.i;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static int LU = 12;
    private static int LV = 4;
    private static int LW = 1;

    /* renamed from: com.kwad.components.core.i.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0466a {
        void e(@Nullable List<c> list);

        void onError(int i10, String str);

        void onRequestResult(int i10);
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0466a interfaceC0466a) {
        a(15, LV, sceneImpl, e.AGGREGATION, interfaceC0466a);
    }

    private static void a(int i10, int i11, @NonNull SceneImpl sceneImpl, final int i12, final InterfaceC0466a interfaceC0466a) {
        SceneImpl m2868clone = sceneImpl.m2868clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m2868clone.setAdStyle(i10);
        m2868clone.setAdNum(i11);
        a(new ImpInfo(m2868clone), null, false, true, new j() { // from class: com.kwad.components.core.i.a.1
            @Override // com.kwad.components.core.request.k
            public final void a(@NonNull final AdResultData adResultData) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.i.a.1.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            InterfaceC0466a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.i.a.1.3
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        InterfaceC0466a.this.e(a.b(adResultData.getAdTemplateList(), i12));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.k
            public final void onError(final int i13, final String str) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.i.a.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i13), str));
                        InterfaceC0466a.this.onError(i13, str);
                    }
                });
            }
        }, false);
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0466a interfaceC0466a) {
        a(17, LW, sceneImpl, e.Mg, interfaceC0466a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new c(iterator2.next(), i10));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j10) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.qi().g(adTemplate, elapsedRealtime - j10);
    }

    private static void a(final ImpInfo impInfo, List<String> list, boolean z10, boolean z11, @NonNull final j jVar, boolean z12) {
        final List list2 = null;
        final boolean z13 = false;
        final boolean z14 = true;
        final boolean z15 = false;
        new com.kwad.components.core.m.a(impInfo) { // from class: com.kwad.components.core.i.a.2
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mO, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z13, null);
                aVar.aF(z14 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.i.a.3
            private void c(@NonNull AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty() && !z15) {
                    jVar.onError(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg);
                } else {
                    jVar.a(adResultData);
                }
            }

            private void h(int i10, String str) {
                jVar.onError(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                h(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }
}
