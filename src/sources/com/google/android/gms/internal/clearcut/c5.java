package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c5 extends com.google.android.gms.common.internal.c<zzn> {
    public c5(Context context, Looper looper, com.google.android.gms.common.internal.b bVar, GoogleApiClient.a aVar, GoogleApiClient.b bVar2) {
        super(context, looper, 40, bVar, aVar, bVar2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.a.f
    public final int g() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return queryLocalInterface instanceof zzn ? (zzn) queryLocalInterface : new zzo(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String y() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String z() {
        return "com.google.android.gms.clearcut.service.START";
    }
}
