package com.mobile.auth.r;

import android.content.Context;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.utils.EncryptUtils;
import com.mobile.auth.w.a;
import com.nirvana.tools.requestqueue.TimeoutCallable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a<T extends com.mobile.auth.w.a> implements TimeoutCallable<com.mobile.auth.w.a> {

    /* renamed from: a, reason: collision with root package name */
    private Context f37577a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.gatewayauth.manager.b f37578b;

    public a(Context context, com.mobile.auth.gatewayauth.manager.b bVar) {
        this.f37577a = context.getApplicationContext();
        this.f37578b = bVar;
    }

    public abstract T a();

    public abstract T a(String str);

    public com.mobile.auth.w.a b() {
        try {
            if (this.f37578b.j()) {
                return a();
            }
            this.f37578b.k();
            return a(EncryptUtils.generateAesKey());
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

    public Context c() {
        try {
            return this.f37577a;
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
}
