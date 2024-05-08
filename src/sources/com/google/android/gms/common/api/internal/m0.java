package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class m0<T> extends s {

    /* renamed from: b, reason: collision with root package name */
    public final p7.g<T> f23474b;

    public m0(int i10, p7.g<T> gVar) {
        super(i10);
        this.f23474b = gVar;
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public void b(@NonNull Status status) {
        this.f23474b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public void d(@NonNull Exception exc) {
        this.f23474b.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void f(g.a<?> aVar) throws DeadObjectException {
        Status e2;
        Status e10;
        try {
            i(aVar);
        } catch (DeadObjectException e11) {
            e10 = e0.e(e11);
            b(e10);
            throw e11;
        } catch (RemoteException e12) {
            e2 = e0.e(e12);
            b(e2);
        } catch (RuntimeException e13) {
            d(e13);
        }
    }

    public abstract void i(g.a<?> aVar) throws RemoteException;
}
