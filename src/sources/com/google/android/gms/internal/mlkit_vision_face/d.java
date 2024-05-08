package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d extends h0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f24799b;

    public d(f fVar) {
        this.f24799b = fVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.h0
    public final Map b() {
        return this.f24799b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.h0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set entrySet = this.f24799b.f24845d.entrySet();
        Objects.requireNonNull(entrySet);
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<Map.Entry> iterator2() {
        return new e(this.f24799b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        zzao.zzo(this.f24799b.f24846e, ((Map.Entry) obj).getKey());
        return true;
    }
}
