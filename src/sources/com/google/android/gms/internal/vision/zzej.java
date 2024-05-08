package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzej<E> extends zzeb<E> implements Set<E> {

    @NullableDecl
    private transient zzee<E> zza;

    public static int zza(int i10) {
        int max = Math.max(i10, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        p0.f(max < 1073741824, "collection too large");
        return 1073741824;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzej) && zzg() && ((zzej) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        return o1.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return o1.a(this);
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public /* synthetic */ Iterator iterator2() {
        return iterator2();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public zzee<E> zze() {
        zzee<E> zzeeVar = this.zza;
        if (zzeeVar != null) {
            return zzeeVar;
        }
        zzee<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public boolean zzg() {
        return false;
    }

    public zzee<E> zzh() {
        return zzee.zza(toArray());
    }
}
