package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements Iterator<Map.Entry> {

    /* renamed from: b, reason: collision with root package name */
    public final Iterator<Map.Entry> f24818b;

    /* renamed from: c, reason: collision with root package name */
    @NullableDecl
    public Collection f24819c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f24820d;

    public e(f fVar) {
        this.f24820d = fVar;
        this.f24818b = fVar.f24845d.entrySet().iterator2();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24818b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Map.Entry next() {
        Map.Entry next = this.f24818b.next();
        this.f24819c = (Collection) next.getValue();
        f fVar = this.f24820d;
        Object key = next.getKey();
        return new zzbh(key, fVar.f24846e.zza(key, (Collection) next.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        a.a(this.f24819c != null, "no calls to next() since the last call to remove()");
        this.f24818b.remove();
        zzao.zzn(this.f24820d.f24846e, this.f24819c.size());
        this.f24819c.clear();
        this.f24819c = null;
    }
}
