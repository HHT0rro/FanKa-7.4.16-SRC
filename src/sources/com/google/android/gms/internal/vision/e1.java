package com.google.android.gms.internal.vision;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e1<T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public int f25454b;

    /* renamed from: c, reason: collision with root package name */
    public int f25455c;

    /* renamed from: d, reason: collision with root package name */
    public int f25456d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzdp f25457e;

    public e1(zzdp zzdpVar) {
        int i10;
        this.f25457e = zzdpVar;
        i10 = zzdpVar.zzf;
        this.f25454b = i10;
        this.f25455c = zzdpVar.zzd();
        this.f25456d = -1;
    }

    public abstract T a(int i10);

    public final void b() {
        int i10;
        i10 = this.f25457e.zzf;
        if (i10 != this.f25454b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f25455c >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        b();
        if (hasNext()) {
            int i10 = this.f25455c;
            this.f25456d = i10;
            T a10 = a(i10);
            this.f25455c = this.f25457e.zza(this.f25455c);
            return a10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        b();
        p0.h(this.f25456d >= 0, "no calls to next() since the last call to remove()");
        this.f25454b += 32;
        zzdp zzdpVar = this.f25457e;
        zzdpVar.remove(zzdpVar.zzb[this.f25456d]);
        this.f25455c = zzdp.zzb(this.f25455c, this.f25456d);
        this.f25456d = -1;
    }

    public /* synthetic */ e1(zzdp zzdpVar, a1 a1Var) {
        this(zzdpVar);
    }
}
