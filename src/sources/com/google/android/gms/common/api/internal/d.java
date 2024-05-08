package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class d<R extends Result, A extends a.b> extends BasePendingResult<R> implements e<R> {

    /* renamed from: a, reason: collision with root package name */
    public final a.c<A> f23423a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.google.android.gms.common.api.a<?> f23424b;

    public d(@RecentlyNonNull com.google.android.gms.common.api.a<?> aVar, @RecentlyNonNull GoogleApiClient googleApiClient) {
        super((GoogleApiClient) com.google.android.gms.common.internal.h.i(googleApiClient, "GoogleApiClient must not be null"));
        com.google.android.gms.common.internal.h.i(aVar, "Api must not be null");
        this.f23423a = (a.c<A>) aVar.b();
        this.f23424b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.e
    public /* bridge */ /* synthetic */ void a(@RecentlyNonNull Object obj) {
        super.setResult((Result) obj);
    }

    public abstract void b(@RecentlyNonNull A a10) throws RemoteException;

    public void c(@RecentlyNonNull R r10) {
    }

    public final void d(@RecentlyNonNull A a10) throws DeadObjectException {
        try {
            b(a10);
        } catch (DeadObjectException e2) {
            e(e2);
            throw e2;
        } catch (RemoteException e10) {
            e(e10);
        }
    }

    public final void e(@NonNull RemoteException remoteException) {
        f(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    public final void f(@RecentlyNonNull Status status) {
        com.google.android.gms.common.internal.h.b(!status.isSuccess(), "Failed result must not be success");
        R createFailedResult = createFailedResult(status);
        setResult(createFailedResult);
        c(createFailedResult);
    }
}
