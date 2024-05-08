package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s1 implements z1 {

    /* renamed from: a, reason: collision with root package name */
    public z1[] f24044a;

    public s1(z1... z1VarArr) {
        this.f24044a = z1VarArr;
    }

    @Override // com.google.android.gms.internal.clearcut.z1
    public final boolean a(Class<?> cls) {
        for (z1 z1Var : this.f24044a) {
            if (z1Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.z1
    public final y1 b(Class<?> cls) {
        for (z1 z1Var : this.f24044a) {
            if (z1Var.a(cls)) {
                return z1Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
