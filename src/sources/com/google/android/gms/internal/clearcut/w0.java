package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w0 implements z1 {

    /* renamed from: a, reason: collision with root package name */
    public static final w0 f24067a = new w0();

    public static w0 c() {
        return f24067a;
    }

    @Override // com.google.android.gms.internal.clearcut.z1
    public final boolean a(Class<?> cls) {
        return x0.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.clearcut.z1
    public final y1 b(Class<?> cls) {
        if (!x0.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (y1) x0.o(cls.asSubclass(x0.class)).i(x0.e.f24083c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}
