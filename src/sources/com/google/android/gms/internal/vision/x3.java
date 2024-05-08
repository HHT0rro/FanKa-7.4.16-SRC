package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x3 implements Comparator<zzht> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzht zzhtVar, zzht zzhtVar2) {
        int zzb;
        int zzb2;
        zzht zzhtVar3 = zzhtVar;
        zzht zzhtVar4 = zzhtVar2;
        z3 z3Var = (z3) zzhtVar3.iterator2();
        z3 z3Var2 = (z3) zzhtVar4.iterator2();
        while (z3Var.hasNext() && z3Var2.hasNext()) {
            zzb = zzht.zzb(z3Var.zza());
            zzb2 = zzht.zzb(z3Var2.zza());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzhtVar3.zza(), zzhtVar4.zza());
    }
}
