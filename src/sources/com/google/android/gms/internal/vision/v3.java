package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v3 extends w3 {

    /* renamed from: b, reason: collision with root package name */
    public int f25662b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f25663c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzht f25664d;

    public v3(zzht zzhtVar) {
        this.f25664d = zzhtVar;
        this.f25663c = zzhtVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25662b < this.f25663c;
    }

    @Override // com.google.android.gms.internal.vision.z3
    public final byte zza() {
        int i10 = this.f25662b;
        if (i10 < this.f25663c) {
            this.f25662b = i10 + 1;
            return this.f25664d.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
