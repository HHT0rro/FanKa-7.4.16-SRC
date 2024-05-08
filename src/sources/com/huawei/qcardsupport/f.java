package com.huawei.qcardsupport;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: JsInterfaces.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Pair<Object, Integer>> f33128a = new HashMap();

    public void a(String str, Object obj, int i10) {
        this.f33128a.put(str, new Pair<>(obj, Integer.valueOf(i10)));
    }

    @NonNull
    public Map<String, Pair<Object, Integer>> a() {
        return this.f33128a;
    }
}
