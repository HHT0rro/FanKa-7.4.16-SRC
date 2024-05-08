package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m2 {

    /* renamed from: c, reason: collision with root package name */
    public static final m2 f23953c = new m2();

    /* renamed from: a, reason: collision with root package name */
    public final s2 f23954a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, r2<?>> f23955b = new ConcurrentHashMap();

    public m2() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        s2 s2Var = null;
        for (int i10 = 0; i10 <= 0; i10++) {
            s2Var = c(strArr[0]);
            if (s2Var != null) {
                break;
            }
        }
        this.f23954a = s2Var == null ? new q1() : s2Var;
    }

    public static m2 a() {
        return f23953c;
    }

    public static s2 c(String str) {
        try {
            return (s2) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> r2<T> b(Class<T> cls) {
        z0.e(cls, "messageType");
        r2<T> r2Var = (r2) this.f23955b.get(cls);
        if (r2Var != null) {
            return r2Var;
        }
        r2<T> a10 = this.f23954a.a(cls);
        z0.e(cls, "messageType");
        z0.e(a10, "schema");
        r2<T> r2Var2 = (r2) this.f23955b.putIfAbsent(cls, a10);
        return r2Var2 != null ? r2Var2 : a10;
    }

    public final <T> r2<T> d(T t2) {
        return b(t2.getClass());
    }
}
