package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f23426a;

    public e0(int i10) {
        this.f23426a = i10;
    }

    public static Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(@NonNull s0 s0Var, boolean z10);

    public abstract void d(@NonNull Exception exc);

    public abstract void f(g.a<?> aVar) throws DeadObjectException;
}
