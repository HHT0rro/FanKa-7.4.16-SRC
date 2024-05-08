package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w extends AbstractCollection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbb f25269b;

    public w(zzbb zzbbVar) {
        this.f25269b = zzbbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f25269b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        zzbb zzbbVar = this.f25269b;
        Map zzc = zzbbVar.zzc();
        if (zzc != null) {
            return zzc.values().iterator2();
        }
        return new r(zzbbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25269b.size();
    }
}
