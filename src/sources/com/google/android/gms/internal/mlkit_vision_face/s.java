package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s extends AbstractSet<Map.Entry> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbb f25187b;

    public s(zzbb zzbbVar) {
        this.f25187b = zzbbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f25187b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        int zzr;
        Map zzc = this.f25187b.zzc();
        if (zzc != null) {
            return zzc.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zzr = this.f25187b.zzr(entry.getKey());
            if (zzr != -1 && w9.a(this.f25187b.zzc[zzr], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<Map.Entry> iterator2() {
        zzbb zzbbVar = this.f25187b;
        Map zzc = zzbbVar.zzc();
        if (zzc != null) {
            return zzc.entrySet().iterator2();
        }
        return new q(zzbbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        int zzp;
        Object obj2;
        Map zzc = this.f25187b.zzc();
        if (zzc != null) {
            return zzc.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f25187b.zzb()) {
            return false;
        }
        zzp = this.f25187b.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        obj2 = this.f25187b.zze;
        zzbb zzbbVar = this.f25187b;
        int e2 = x.e(key, value, zzp, obj2, zzbbVar.zza, zzbbVar.zzb, zzbbVar.zzc);
        if (e2 == -1) {
            return false;
        }
        this.f25187b.zze(e2, zzp);
        zzbb.zzn(this.f25187b);
        this.f25187b.zzd();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25187b.size();
    }
}
