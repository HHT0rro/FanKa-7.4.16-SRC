package com.huawei.quickcard;

import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.value.QuickCardValue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b2 {

    /* renamed from: a, reason: collision with root package name */
    private String f33281a;

    /* renamed from: b, reason: collision with root package name */
    private String f33282b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<IVirtualViewParent> f33283c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Map<String, QuickCardValue>> f33284d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Map<String, QuickCardValue>> f33285e = new HashMap();

    public String a() {
        return this.f33281a;
    }

    public void b(String str) {
        this.f33282b = str;
    }

    public Map<String, Map<String, QuickCardValue>> c() {
        return this.f33284d;
    }

    public Map<String, Map<String, QuickCardValue>> d() {
        return this.f33285e;
    }

    public String e() {
        return this.f33282b;
    }

    public void a(String str) {
        this.f33281a = str;
    }

    public IVirtualViewParent b() {
        WeakReference<IVirtualViewParent> weakReference = this.f33283c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void a(IVirtualViewParent iVirtualViewParent) {
        this.f33283c = new WeakReference<>(iVirtualViewParent);
    }
}
