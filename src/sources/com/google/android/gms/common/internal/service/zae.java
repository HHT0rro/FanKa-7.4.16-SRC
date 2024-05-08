package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zae extends zaa {
    private final e<Status> zaa;

    public zae(e<Status> eVar) {
        this.zaa = eVar;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zai
    public final void zaa(int i10) throws RemoteException {
        this.zaa.a(new Status(i10));
    }
}
