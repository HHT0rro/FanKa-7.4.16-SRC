package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w5 implements d6 {

    /* renamed from: a, reason: collision with root package name */
    public d6[] f25671a;

    public w5(d6... d6VarArr) {
        this.f25671a = d6VarArr;
    }

    @Override // com.google.android.gms.internal.vision.d6
    public final boolean a(Class<?> cls) {
        for (d6 d6Var : this.f25671a) {
            if (d6Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.d6
    public final a6 b(Class<?> cls) {
        for (d6 d6Var : this.f25671a) {
            if (d6Var.a(cls)) {
                return d6Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
