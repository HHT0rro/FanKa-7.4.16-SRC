package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.internal.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<Object>, e8.a<Object>> f27095a = new HashMap();

    /* compiled from: com.google.mlkit:vision-common@@16.3.0 */
    /* renamed from: com.google.mlkit.vision.common.internal.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0244a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<Object> f27096a;

        /* renamed from: b, reason: collision with root package name */
        public final e8.a<Object> f27097b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27098c;

        public final Class<Object> a() {
            return this.f27096a;
        }

        public final e8.a<Object> b() {
            return this.f27097b;
        }

        public final int c() {
            return this.f27098c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Set<C0244a> set) {
        HashMap hashMap = new HashMap();
        for (C0244a c0244a : set) {
            Class<Object> a10 = c0244a.a();
            if (!this.f27095a.containsKey(a10) || c0244a.c() >= ((Integer) h.h((Integer) hashMap.get(a10))).intValue()) {
                this.f27095a.put(a10, c0244a.b());
                hashMap.put(a10, Integer.valueOf(c0244a.c()));
            }
        }
    }
}
