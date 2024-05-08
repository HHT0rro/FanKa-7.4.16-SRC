package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
@KeepName
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    public static final ThreadLocal<Boolean> zaa = new q0();

    @KeepName
    private zaa mResultGuardian;
    private final Object zab;
    private final CallbackHandler<R> zac;
    private final WeakReference<GoogleApiClient> zad;
    private final CountDownLatch zae;
    private final ArrayList<PendingResult.StatusListener> zaf;

    @Nullable
    private ResultCallback<? super R> zag;
    private final AtomicReference<zacn> zah;

    @Nullable
    private R zai;
    private Status zaj;
    private volatile boolean zak;
    private boolean zal;
    private boolean zam;

    @Nullable
    private ICancelToken zan;
    private volatile zack<R> zao;
    private boolean zap;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class CallbackHandler<R extends Result> extends h7.g {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public final void a(@RecentlyNonNull ResultCallback<? super R> resultCallback, @RecentlyNonNull R r10) {
            sendMessage(obtainMessage(1, new Pair((ResultCallback) com.google.android.gms.common.internal.h.h(BasePendingResult.zab(resultCallback)), r10)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(@RecentlyNonNull Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    StringBuilder sb2 = new StringBuilder(45);
                    sb2.append("Don't know how to handle message: ");
                    sb2.append(i10);
                    Log.wtf("BasePendingResult", sb2.toString(), new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f23381j);
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.a(result);
            } catch (RuntimeException e2) {
                BasePendingResult.zaa(result);
                throw e2;
            }
        }

        public CallbackHandler(@RecentlyNonNull Looper looper) {
            super(looper);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class zaa {
        public zaa() {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.zaa(BasePendingResult.this.zai);
            super.finalize();
        }

        public /* synthetic */ zaa(BasePendingResult basePendingResult, q0 q0Var) {
            this();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(Looper.getMainLooper());
        this.zad = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static <R extends Result> ResultCallback<R> zab(@Nullable ResultCallback<R> resultCallback) {
        return resultCallback;
    }

    private final R zac() {
        R r10;
        synchronized (this.zab) {
            com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed.");
            com.google.android.gms.common.internal.h.k(isReady(), "Result is not ready.");
            r10 = this.zai;
            this.zai = null;
            this.zag = null;
            this.zak = true;
        }
        zacn andSet = this.zah.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return (R) com.google.android.gms.common.internal.h.h(r10);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@RecentlyNonNull PendingResult.StatusListener statusListener) {
        com.google.android.gms.common.internal.h.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.zab) {
            if (isReady()) {
                statusListener.a(this.zaj);
            } else {
                this.zaf.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public final R await() {
        com.google.android.gms.common.internal.h.g("await must not be called on the UI thread");
        com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed");
        com.google.android.gms.common.internal.h.k(this.zao == null, "Cannot await if then() has been called.");
        try {
            this.zae.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f23379h);
        }
        com.google.android.gms.common.internal.h.k(isReady(), "Result is not ready.");
        return zac();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zab) {
            if (!this.zal && !this.zak) {
                ICancelToken iCancelToken = this.zan;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zaa(this.zai);
                this.zal = true;
                zab((BasePendingResult<R>) createFailedResult(Status.f23382k));
            }
        }
    }

    @NonNull
    public abstract R createFailedResult(@RecentlyNonNull Status status);

    @Deprecated
    public final void forceFailureUnlessReady(@RecentlyNonNull Status status) {
        synchronized (this.zab) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zam = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public boolean isCanceled() {
        boolean z10;
        synchronized (this.zab) {
            z10 = this.zal;
        }
        return z10;
    }

    @RecentlyNonNull
    public final boolean isReady() {
        return this.zae.getCount() == 0;
    }

    public final void setCancelToken(@RecentlyNonNull ICancelToken iCancelToken) {
        synchronized (this.zab) {
            this.zan = iCancelToken;
        }
    }

    public final void setResult(@RecentlyNonNull R r10) {
        synchronized (this.zab) {
            if (!this.zam && !this.zal) {
                isReady();
                boolean z10 = true;
                com.google.android.gms.common.internal.h.k(!isReady(), "Results have already been set");
                if (this.zak) {
                    z10 = false;
                }
                com.google.android.gms.common.internal.h.k(z10, "Result has already been consumed");
                zab((BasePendingResult<R>) r10);
                return;
            }
            zaa(r10);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@Nullable ResultCallback<? super R> resultCallback) {
        synchronized (this.zab) {
            if (resultCallback == null) {
                this.zag = null;
                return;
            }
            boolean z10 = true;
            com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z10 = false;
            }
            com.google.android.gms.common.internal.h.k(z10, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zac.a(resultCallback, zac());
            } else {
                this.zag = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public <S extends Result> TransformedResult<S> then(@RecentlyNonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed.");
        synchronized (this.zab) {
            com.google.android.gms.common.internal.h.k(this.zao == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.h.k(this.zag == null, "Cannot call then() if callbacks are set.");
            com.google.android.gms.common.internal.h.k(this.zal ? false : true, "Cannot call then() if result was canceled.");
            this.zap = true;
            this.zao = new zack<>(this.zad);
            then = this.zao.then(resultTransform);
            if (isReady()) {
                this.zac.a(this.zao, zac());
            } else {
                this.zag = this.zao;
            }
        }
        return then;
    }

    @RecentlyNonNull
    public final boolean zaa() {
        boolean isCanceled;
        synchronized (this.zab) {
            if (this.zad.get() == null || !this.zap) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zab() {
        this.zap = this.zap || zaa.get().booleanValue();
    }

    private final void zab(R r10) {
        this.zai = r10;
        this.zaj = r10.getStatus();
        q0 q0Var = null;
        this.zan = null;
        this.zae.countDown();
        if (this.zal) {
            this.zag = null;
        } else {
            ResultCallback<? super R> resultCallback = this.zag;
            if (resultCallback == null) {
                if (this.zai instanceof u6.c) {
                    this.mResultGuardian = new zaa(this, q0Var);
                }
            } else {
                this.zac.removeMessages(2);
                this.zac.a(resultCallback, zac());
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zaf;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i10);
            i10++;
            statusListener.a(this.zaj);
        }
        this.zaf.clear();
    }

    public final void zaa(@Nullable zacn zacnVar) {
        this.zah.set(zacnVar);
    }

    public static void zaa(@Nullable Result result) {
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

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public final R await(@RecentlyNonNull long j10, @RecentlyNonNull TimeUnit timeUnit) {
        if (j10 > 0) {
            com.google.android.gms.common.internal.h.g("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed.");
        com.google.android.gms.common.internal.h.k(this.zao == null, "Cannot await if then() has been called.");
        try {
            if (!this.zae.await(j10, timeUnit)) {
                forceFailureUnlessReady(Status.f23381j);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f23379h);
        }
        com.google.android.gms.common.internal.h.k(isReady(), "Result is not ready.");
        return zac();
    }

    public BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(googleApiClient != null ? googleApiClient.a() : Looper.getMainLooper());
        this.zad = new WeakReference<>(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@RecentlyNonNull ResultCallback<? super R> resultCallback, @RecentlyNonNull long j10, @RecentlyNonNull TimeUnit timeUnit) {
        synchronized (this.zab) {
            if (resultCallback == null) {
                this.zag = null;
                return;
            }
            boolean z10 = true;
            com.google.android.gms.common.internal.h.k(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z10 = false;
            }
            com.google.android.gms.common.internal.h.k(z10, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zac.a(resultCallback, zac());
            } else {
                this.zag = resultCallback;
                CallbackHandler<R> callbackHandler = this.zac;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j10));
            }
        }
    }

    @Deprecated
    public BasePendingResult(@RecentlyNonNull Looper looper) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(looper);
        this.zad = new WeakReference<>(null);
    }

    public BasePendingResult(@RecentlyNonNull CallbackHandler<R> callbackHandler) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = (CallbackHandler) com.google.android.gms.common.internal.h.i(callbackHandler, "CallbackHandler must not be null");
        this.zad = new WeakReference<>(null);
    }
}
