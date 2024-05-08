package com.alibaba.security.realidentity.build;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: RPUploadTaskCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bb {

    /* renamed from: b, reason: collision with root package name */
    private static bb f3148b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, Object> f3149a = new HashMap<>();

    private bb() {
    }

    public static bb a() {
        if (f3148b == null) {
            f3148b = new bb();
        }
        return f3148b;
    }

    private void c() {
        synchronized (this.f3149a) {
            this.f3149a.clear();
        }
    }

    public final Set<Map.Entry<String, Object>> b() {
        Set<Map.Entry<String, Object>> entrySet;
        synchronized (this.f3149a) {
            entrySet = this.f3149a.entrySet();
        }
        return entrySet;
    }

    private void a(String str, Object obj) {
        synchronized (this.f3149a) {
            if (str != null && obj != null) {
                this.f3149a.put(str, obj);
            }
        }
    }

    public final void b(String str) {
        synchronized (this.f3149a) {
            if (this.f3149a.containsKey(str)) {
                this.f3149a.remove(str);
            }
        }
    }

    public final Object a(String str) {
        synchronized (this.f3149a) {
            if (!this.f3149a.containsKey(str)) {
                return null;
            }
            return this.f3149a.get(str);
        }
    }
}
