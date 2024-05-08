package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Result f23470b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zack f23471c;

    public j0(zack zackVar, Result result) {
        this.f23471c = zackVar;
        this.f23470b = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        WeakReference weakReference;
        k0 k0Var;
        k0 k0Var2;
        WeakReference weakReference2;
        ResultTransform resultTransform;
        k0 k0Var3;
        k0 k0Var4;
        WeakReference weakReference3;
        try {
            try {
                ThreadLocal<Boolean> threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                resultTransform = this.f23471c.f23499a;
                PendingResult b4 = ((ResultTransform) com.google.android.gms.common.internal.h.h(resultTransform)).b(this.f23470b);
                k0Var3 = this.f23471c.f23506h;
                k0Var4 = this.f23471c.f23506h;
                k0Var3.sendMessage(k0Var4.obtainMessage(0, b4));
                threadLocal.set(Boolean.FALSE);
                zack zackVar = this.f23471c;
                zack.d(this.f23470b);
                weakReference3 = this.f23471c.f23505g;
                GoogleApiClient googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient != null) {
                    googleApiClient.c(this.f23471c);
                }
            } catch (RuntimeException e2) {
                k0Var = this.f23471c.f23506h;
                k0Var2 = this.f23471c.f23506h;
                k0Var.sendMessage(k0Var2.obtainMessage(1, e2));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zack zackVar2 = this.f23471c;
                zack.d(this.f23470b);
                weakReference2 = this.f23471c.f23505g;
                GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference2.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.c(this.f23471c);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zack zackVar3 = this.f23471c;
            zack.d(this.f23470b);
            weakReference = this.f23471c.f23505g;
            GoogleApiClient googleApiClient3 = (GoogleApiClient) weakReference.get();
            if (googleApiClient3 != null) {
                googleApiClient3.c(this.f23471c);
            }
            throw th;
        }
    }
}
