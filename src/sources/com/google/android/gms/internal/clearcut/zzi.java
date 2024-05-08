package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.api.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzi extends zzg {
    private final /* synthetic */ z4 zzap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(z4 z4Var) {
        super(null);
        this.zzap = z4Var;
    }

    @Override // com.google.android.gms.internal.clearcut.zzg, com.google.android.gms.internal.clearcut.zzl
    public final void zza(Status status) {
        this.zzap.setResult(status);
    }
}
