package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends o7 {

    /* renamed from: a, reason: collision with root package name */
    public final b f24254a = new b();

    @Override // com.google.android.gms.internal.mlkit_vision_common.o7
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.f24254a.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
