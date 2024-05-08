package com.huawei.quickcard;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FullScreenExtendedParams {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, WeakReference<Object>> f33236a = new HashMap<>();

    public void clearAll() {
        this.f33236a.clear();
    }

    public Object getParam(String str) {
        WeakReference<Object> weakReference = this.f33236a.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void removeParam(String str) {
        this.f33236a.remove(str);
    }

    public void setParam(String str, Object obj) {
        this.f33236a.put(str, new WeakReference<>(obj));
    }

    public void setParams(HashMap<String, WeakReference<Object>> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        this.f33236a.putAll(hashMap);
    }
}
