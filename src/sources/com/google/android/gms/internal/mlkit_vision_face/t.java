package com.google.android.gms.internal.mlkit_vision_face;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class t<T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public int f25208b;

    /* renamed from: c, reason: collision with root package name */
    public int f25209c;

    /* renamed from: d, reason: collision with root package name */
    public int f25210d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbb f25211e;

    public /* synthetic */ t(zzbb zzbbVar, p pVar) {
        int i10;
        this.f25211e = zzbbVar;
        i10 = zzbbVar.zzf;
        this.f25208b = i10;
        this.f25209c = zzbbVar.zzf();
        this.f25210d = -1;
    }

    public abstract T a(int i10);

    public final void b() {
        int i10;
        i10 = this.f25211e.zzf;
        if (i10 != this.f25208b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25209c >= 0;
    }

    @Override // java.util.Iterator
    public final T next() {
        b();
        if (hasNext()) {
            int i10 = this.f25209c;
            this.f25210d = i10;
            T a10 = a(i10);
            this.f25209c = this.f25211e.zzg(this.f25209c);
            return a10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        b();
        a.a(this.f25210d >= 0, "no calls to next() since the last call to remove()");
        this.f25208b += 32;
        zzbb zzbbVar = this.f25211e;
        zzbbVar.remove(zzbbVar.zzb[this.f25210d]);
        this.f25209c--;
        this.f25210d = -1;
    }
}
