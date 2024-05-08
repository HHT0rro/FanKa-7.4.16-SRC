package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y5 implements z5 {
    @Override // com.google.android.gms.internal.vision.z5
    public final Map<?, ?> a(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final Map<?, ?> b(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final boolean c(Object obj) {
        return !((zzke) obj).zzd();
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final Object d(Object obj, Object obj2) {
        zzke zzkeVar = (zzke) obj;
        zzke zzkeVar2 = (zzke) obj2;
        if (!zzkeVar2.isEmpty()) {
            if (!zzkeVar.zzd()) {
                zzkeVar = zzkeVar.zzb();
            }
            zzkeVar.zza(zzkeVar2);
        }
        return zzkeVar;
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final Object e(Object obj) {
        return zzke.zza().zzb();
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final Object f(Object obj) {
        ((zzke) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final int g(int i10, Object obj, Object obj2) {
        zzke zzkeVar = (zzke) obj;
        if (zzkeVar.isEmpty()) {
            return 0;
        }
        Iterator iterator2 = zzkeVar.entrySet().iterator2();
        if (!iterator2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) iterator2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.z5
    public final x5<?, ?> zzb(Object obj) {
        throw new NoSuchMethodError();
    }
}
