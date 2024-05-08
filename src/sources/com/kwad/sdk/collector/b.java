package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static com.kwad.sdk.collector.a Av() {
        return new a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i10 = 0; i10 < size; i10++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i10);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i10] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.Ax()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    StringBuilder sb2 = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb2.append((Object) analysis);
                    com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", sb2.toString());
                    for (long j10 : analysis) {
                        arrayList.add(new AppRunningInfoNative(j10));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.e.c.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j10, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i10 = 0; i10 < size; i10++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i10);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i10] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.Ax()) {
                try {
                    for (long j11 : AppStatusNative.nativeGetUploadEntry(jArr, j10, str)) {
                        arrayList.add(new UploadEntryNative(j11));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}
