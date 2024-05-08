package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.a;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AnalyseTaskNative extends NativeObject implements a {
    public AnalyseTaskNative(AppRunningInfoNative appRunningInfoNative, Set<String> set, long j10) {
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        this.mPtr = AppStatusNative.nativeCreateAnalyseTask(appRunningInfoNative.mPtr, strArr, j10);
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j10 = this.mPtr;
        if (j10 != 0) {
            AppStatusNative.nativeDeleteAnalyseTask(j10);
            this.mPtr = 0L;
        }
    }
}
