package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y4 implements d6 {

    /* renamed from: a, reason: collision with root package name */
    public static final y4 f25705a = new y4();

    public static y4 c() {
        return f25705a;
    }

    @Override // com.google.android.gms.internal.vision.d6
    public final boolean a(Class<?> cls) {
        return x4.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.vision.d6
    public final a6 b(Class<?> cls) {
        if (!x4.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (a6) x4.l(cls.asSubclass(x4.class)).n(x4.g.f25690c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}
