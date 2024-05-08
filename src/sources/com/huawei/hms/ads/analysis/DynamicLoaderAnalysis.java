package com.huawei.hms.ads.analysis;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DynamicLoaderAnalysis {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f29050a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private static DynamicLoaderAnalysis f29051b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, IDynamicLoaderAnalysis> f29052c;

    private DynamicLoaderAnalysis() {
    }

    public static DynamicLoaderAnalysis getInstance() {
        DynamicLoaderAnalysis dynamicLoaderAnalysis;
        synchronized (f29050a) {
            if (f29051b == null) {
                f29051b = new DynamicLoaderAnalysis();
            }
            dynamicLoaderAnalysis = f29051b;
        }
        return dynamicLoaderAnalysis;
    }

    public void onLoaderException(String str, int i10, String str2) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.f29052c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderException(entry.getKey(), str, i10, str2);
            }
        }
    }

    public void onLoaderSuccess(String str, long j10) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.f29052c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderSuccess(entry.getKey(), str, j10);
            }
        }
    }

    public void registerDynamicLoaderAnalysis(String str, IDynamicLoaderAnalysis iDynamicLoaderAnalysis) {
        if (TextUtils.isEmpty(str) || iDynamicLoaderAnalysis == null) {
            return;
        }
        if (this.f29052c == null) {
            this.f29052c = new HashMap<>();
        }
        if (this.f29052c.containsKey(str)) {
            return;
        }
        this.f29052c.put(str, iDynamicLoaderAnalysis);
    }
}
