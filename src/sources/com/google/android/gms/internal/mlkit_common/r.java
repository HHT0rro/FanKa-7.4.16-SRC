package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r extends o {

    /* renamed from: a, reason: collision with root package name */
    public final q f24195a = new q();

    @Override // com.google.android.gms.internal.mlkit_common.o
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.f24195a.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
