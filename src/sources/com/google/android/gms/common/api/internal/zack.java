package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zack<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: g, reason: collision with root package name */
    public final WeakReference<GoogleApiClient> f23505g;

    /* renamed from: h, reason: collision with root package name */
    public final k0 f23506h;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public ResultTransform<? super R, ? extends Result> f23499a = null;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public zack<? extends Result> f23500b = null;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public volatile ResultCallbacks<? super R> f23501c = null;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public PendingResult<R> f23502d = null;

    /* renamed from: e, reason: collision with root package name */
    public final Object f23503e = new Object();

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Status f23504f = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23507i = false;

    public zack(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.h.i(weakReference, "GoogleApiClient reference must not be null");
        this.f23505g = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.f23506h = new k0(this, googleApiClient != null ? googleApiClient.a() : Looper.getMainLooper());
    }

    public static void d(Result result) {
        if (result instanceof u6.c) {
            try {
                ((u6.c) result).release();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(result);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append("Unable to release ");
                sb2.append(valueOf);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(R r10) {
        synchronized (this.f23503e) {
            if (r10.getStatus().isSuccess()) {
                if (this.f23499a != null) {
                    f0.a().submit(new j0(this, r10));
                } else if (l()) {
                    ((ResultCallbacks) com.google.android.gms.common.internal.h.h(this.f23501c)).c(r10);
                }
            } else {
                e(r10.getStatus());
                d(r10);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.f23503e) {
            boolean z10 = true;
            com.google.android.gms.common.internal.h.k(this.f23501c == null, "Cannot call andFinally() twice.");
            if (this.f23499a != null) {
                z10 = false;
            }
            com.google.android.gms.common.internal.h.k(z10, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f23501c = resultCallbacks;
            i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(PendingResult<?> pendingResult) {
        synchronized (this.f23503e) {
            this.f23502d = pendingResult;
            i();
        }
    }

    public final void e(Status status) {
        synchronized (this.f23503e) {
            this.f23504f = status;
            j(status);
        }
    }

    public final void i() {
        if (this.f23499a == null && this.f23501c == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f23505g.get();
        if (!this.f23507i && this.f23499a != null && googleApiClient != null) {
            googleApiClient.b(this);
            this.f23507i = true;
        }
        Status status = this.f23504f;
        if (status != null) {
            j(status);
            return;
        }
        PendingResult<R> pendingResult = this.f23502d;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    public final void j(Status status) {
        synchronized (this.f23503e) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.f23499a;
            if (resultTransform != null) {
                ((zack) com.google.android.gms.common.internal.h.h(this.f23500b)).e((Status) com.google.android.gms.common.internal.h.i(resultTransform.a(status), "onFailure must not return null"));
            } else if (l()) {
                ((ResultCallbacks) com.google.android.gms.common.internal.h.h(this.f23501c)).b(status);
            }
        }
    }

    public final boolean l() {
        return (this.f23501c == null || this.f23505g.get() == null) ? false : true;
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zack<? extends Result> zackVar;
        synchronized (this.f23503e) {
            boolean z10 = true;
            com.google.android.gms.common.internal.h.k(this.f23499a == null, "Cannot call then() twice.");
            if (this.f23501c != null) {
                z10 = false;
            }
            com.google.android.gms.common.internal.h.k(z10, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f23499a = resultTransform;
            zackVar = new zack<>(this.f23505g);
            this.f23500b = zackVar;
            i();
        }
        return zackVar;
    }
}
