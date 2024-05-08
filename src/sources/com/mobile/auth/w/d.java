package com.mobile.auth.w;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.TimeoutResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends TimeoutResponse {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37661a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37662b;

    /* renamed from: c, reason: collision with root package name */
    private String f37663c;

    public d(boolean z10, boolean z11) {
        super(z10);
        this.f37662b = false;
        this.f37661a = z11;
    }

    public String a() {
        try {
            return this.f37663c;
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

    public void a(String str) {
        try {
            this.f37663c = str;
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
            this.f37661a = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.nirvana.tools.requestqueue.TimeoutResponse
    public boolean isResultTimeout() {
        try {
            return this.f37662b;
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
}
