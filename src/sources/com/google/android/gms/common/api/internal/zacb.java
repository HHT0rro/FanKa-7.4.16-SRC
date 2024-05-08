package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zacb extends zad implements GoogleApiClient.a, GoogleApiClient.b {
    private static a.AbstractC0213a<? extends n7.e, n7.a> zaa = n7.b.f52158c;
    private final Context zab;
    private final Handler zac;
    private final a.AbstractC0213a<? extends n7.e, n7.a> zad;
    private Set<Scope> zae;
    private com.google.android.gms.common.internal.b zaf;
    private n7.e zag;
    private i0 zah;

    @WorkerThread
    public zacb(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.b bVar) {
        this(context, handler, bVar, zaa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zab(zam zamVar) {
        ConnectionResult f10 = zamVar.f();
        if (f10.isSuccess()) {
            zas zasVar = (zas) com.google.android.gms.common.internal.h.h(zamVar.g());
            ConnectionResult g3 = zasVar.g();
            if (!g3.isSuccess()) {
                String valueOf = String.valueOf(g3);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
                sb2.append("Sign-in succeeded with resolve account failure: ");
                sb2.append(valueOf);
                Log.wtf("SignInCoordinator", sb2.toString(), new Exception());
                this.zah.c(g3);
                this.zag.disconnect();
                return;
            }
            this.zah.b(zasVar.f(), this.zae);
        } else {
            this.zah.c(f10);
        }
        this.zag.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.f
    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zag.j(this);
    }

    @Override // com.google.android.gms.common.api.internal.k
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zah.c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.f
    @WorkerThread
    public final void onConnectionSuspended(int i10) {
        this.zag.disconnect();
    }

    @WorkerThread
    public final void zaa(i0 i0Var) {
        n7.e eVar = this.zag;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.zaf.f(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0213a<? extends n7.e, n7.a> abstractC0213a = this.zad;
        Context context = this.zab;
        Looper looper = this.zac.getLooper();
        com.google.android.gms.common.internal.b bVar = this.zaf;
        this.zag = abstractC0213a.a(context, looper, bVar, bVar.h(), this, this);
        this.zah = i0Var;
        Set<Scope> set = this.zae;
        if (set != null && !set.isEmpty()) {
            this.zag.d();
        } else {
            this.zac.post(new h0(this));
        }
    }

    @WorkerThread
    private zacb(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.b bVar, a.AbstractC0213a<? extends n7.e, n7.a> abstractC0213a) {
        this.zab = context;
        this.zac = handler;
        this.zaf = (com.google.android.gms.common.internal.b) com.google.android.gms.common.internal.h.i(bVar, "ClientSettings must not be null");
        this.zae = bVar.e();
        this.zad = abstractC0213a;
    }

    public final void zaa() {
        n7.e eVar = this.zag;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // com.google.android.gms.signin.internal.zad, com.google.android.gms.signin.internal.zac
    @BinderThread
    public final void zaa(zam zamVar) {
        this.zac.post(new g0(this, zamVar));
    }
}
