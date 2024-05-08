package com.mobile.auth.w;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.TimeoutResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f extends TimeoutResponse {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37667a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.gatewayauth.manager.base.b f37668b;

    public f(boolean z10) {
        super(z10);
    }

    public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
        try {
            this.f37668b = bVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(boolean z10) {
        try {
            this.f37667a = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean a() {
        try {
            return this.f37667a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public com.mobile.auth.gatewayauth.manager.base.b b() {
        try {
            return this.f37668b;
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

    @Override // com.nirvana.tools.requestqueue.TimeoutResponse
    public boolean isResultTimeout() {
        return false;
    }
}
