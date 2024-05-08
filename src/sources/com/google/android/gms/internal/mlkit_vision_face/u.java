package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u extends AbstractSet {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbb f25233b;

    public u(zzbb zzbbVar) {
        this.f25233b = zzbbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f25233b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f25233b.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        zzbb zzbbVar = this.f25233b;
        Map zzc = zzbbVar.zzc();
        if (zzc != null) {
            return zzc.h().iterator2();
        }
        return new p(zzbbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Object zzs;
        Object obj2;
        Map zzc = this.f25233b.zzc();
        if (zzc != null) {
            return zzc.h().remove(obj);
        }
        zzs = this.f25233b.zzs(obj);
        obj2 = zzbb.zzd;
        return zzs != obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25233b.size();
    }
}
