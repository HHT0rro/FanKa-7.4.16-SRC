package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t0<T> implements q0<T> {

    /* renamed from: b, reason: collision with root package name */
    public volatile q0<T> f25640b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f25641c;

    /* renamed from: d, reason: collision with root package name */
    @NullableDecl
    public T f25642d;

    public t0(q0<T> q0Var) {
        this.f25640b = (q0) p0.b(q0Var);
    }

    public final String toString() {
        Object obj = this.f25640b;
        if (obj == null) {
            String valueOf = String.valueOf(this.f25642d);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf2);
        sb3.append(")");
        return sb3.toString();
    }

    @Override // com.google.android.gms.internal.vision.q0
    public final T zza() {
        if (!this.f25641c) {
            synchronized (this) {
                if (!this.f25641c) {
                    T zza = this.f25640b.zza();
                    this.f25642d = zza;
                    this.f25641c = true;
                    this.f25640b = null;
                    return zza;
                }
            }
        }
        return this.f25642d;
    }
}
