package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i<E> extends c<E> {

    /* renamed from: d, reason: collision with root package name */
    public final zzak<E> f24179d;

    public i(zzak<E> zzakVar, int i10) {
        super(zzakVar.size(), i10);
        this.f24179d = zzakVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.c
    public final E a(int i10) {
        return this.f24179d.get(i10);
    }
}
