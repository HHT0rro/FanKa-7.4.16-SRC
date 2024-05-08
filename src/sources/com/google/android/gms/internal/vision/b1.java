package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b1 extends AbstractSet {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdp f25433b;

    public b1(zzdp zzdpVar) {
        this.f25433b = zzdpVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f25433b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        int zza;
        Map zzb = this.f25433b.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zza = this.f25433b.zza(entry.getKey());
            if (zza != -1 && k0.a(this.f25433b.zzc[zza], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator iterator2() {
        return this.f25433b.zzf();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        int zzi;
        Object obj2;
        Map zzb = this.f25433b.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f25433b.zza()) {
            return false;
        }
        zzi = this.f25433b.zzi();
        Object key = entry.getKey();
        Object value = entry.getValue();
        obj2 = this.f25433b.zze;
        zzdp zzdpVar = this.f25433b;
        int c4 = i1.c(key, value, zzi, obj2, zzdpVar.zza, zzdpVar.zzb, zzdpVar.zzc);
        if (c4 == -1) {
            return false;
        }
        this.f25433b.zza(c4, zzi);
        zzdp.zzd(this.f25433b);
        this.f25433b.zzc();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25433b.size();
    }
}
