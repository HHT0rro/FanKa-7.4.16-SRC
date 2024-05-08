package com.google.android.gms.internal.clearcut;

import com.google.protobuf.ExtensionRegistry;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f23930a = a();

    public static Class<?> a() {
        try {
            ExtensionRegistry extensionRegistry = ExtensionRegistry.EMPTY_REGISTRY;
            return ExtensionRegistry.class;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static l0 b() {
        Class<?> cls = f23930a;
        if (cls != null) {
            try {
                return (l0) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return l0.f23951c;
    }
}
