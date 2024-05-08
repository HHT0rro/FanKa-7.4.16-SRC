package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z4 extends com.google.android.gms.common.api.internal.d<Status, c5> {

    /* renamed from: c, reason: collision with root package name */
    public final zze f24129c;

    public z4(zze zzeVar, GoogleApiClient googleApiClient) {
        super(com.google.android.gms.clearcut.a.f23310p, googleApiClient);
        this.f24129c = zzeVar;
    }

    @Override // com.google.android.gms.common.api.internal.d
    public final /* synthetic */ void b(c5 c5Var) throws RemoteException {
        c5 c5Var2 = c5Var;
        zzi zziVar = new zzi(this);
        try {
            zze zzeVar = this.f24129c;
            a.c cVar = zzeVar.f23354k;
            if (cVar != null) {
                a5 a5Var = zzeVar.f23353j;
                if (a5Var.f23800o.length == 0) {
                    a5Var.f23800o = cVar.zza();
                }
            }
            a.c cVar2 = zzeVar.f23355l;
            if (cVar2 != null) {
                a5 a5Var2 = zzeVar.f23353j;
                if (a5Var2.f23807v.length == 0) {
                    a5Var2.f23807v = cVar2.zza();
                }
            }
            a5 a5Var3 = zzeVar.f23353j;
            int d10 = a5Var3.d();
            byte[] bArr = new byte[d10];
            c4.c(a5Var3, bArr, 0, d10);
            zzeVar.f23346c = bArr;
            ((zzn) c5Var2.x()).zza(zziVar, this.f24129c);
        } catch (RuntimeException unused) {
            f(new Status(10, "MessageProducer"));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
