package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w1 implements v1 {
    @Override // com.google.android.gms.internal.clearcut.v1
    public final Object e(Object obj, Object obj2) {
        zzdi zzdiVar = (zzdi) obj;
        zzdi zzdiVar2 = (zzdi) obj2;
        if (!zzdiVar2.isEmpty()) {
            if (!zzdiVar.isMutable()) {
                zzdiVar = zzdiVar.zzca();
            }
            zzdiVar.zza(zzdiVar2);
        }
        return zzdiVar;
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final int f(int i10, Object obj, Object obj2) {
        zzdi zzdiVar = (zzdi) obj;
        if (zzdiVar.isEmpty()) {
            return 0;
        }
        Iterator iterator2 = zzdiVar.entrySet().iterator2();
        if (!iterator2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) iterator2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final u1<?, ?> g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final Object h(Object obj) {
        return zzdi.zzbz().zzca();
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final Object i(Object obj) {
        ((zzdi) obj).zzv();
        return obj;
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final boolean j(Object obj) {
        return !((zzdi) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final Map<?, ?> k(Object obj) {
        return (zzdi) obj;
    }

    @Override // com.google.android.gms.internal.clearcut.v1
    public final Map<?, ?> l(Object obj) {
        return (zzdi) obj;
    }
}
