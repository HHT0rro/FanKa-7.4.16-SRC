package com.mobile.auth.r;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.TimeoutCallable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements TimeoutCallable<com.mobile.auth.w.d> {

    /* renamed from: a, reason: collision with root package name */
    private Context f37584a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.q.a f37585b;

    public d(Context context, com.mobile.auth.q.a aVar) {
        this.f37584a = context;
        this.f37585b = aVar;
    }

    private void a(Context context, com.mobile.auth.w.d dVar) {
        try {
            String b4 = com.mobile.auth.gatewayauth.utils.c.b();
            if (TextUtils.isEmpty(b4)) {
                dVar.a(false);
            } else {
                dVar.a(true);
                dVar.a(b4);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public com.mobile.auth.w.d a() {
        try {
            return new com.mobile.auth.w.d(true, false);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public com.mobile.auth.w.d b() throws Exception {
        try {
            com.mobile.auth.w.d dVar = new com.mobile.auth.w.d(false, false);
            a(this.f37584a, dVar);
            return dVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Object call() throws Exception {
        try {
            return b();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    @Override // com.nirvana.tools.requestqueue.TimeoutCallable
    public /* synthetic */ com.mobile.auth.w.d onTimeout() {
        try {
            return a();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
