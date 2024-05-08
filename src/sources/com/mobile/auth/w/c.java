package com.mobile.auth.w;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.ConfigRule;
import com.nirvana.tools.requestqueue.TimeoutResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends TimeoutResponse {

    /* renamed from: a, reason: collision with root package name */
    private ConfigRule f37660a;

    public c(boolean z10) {
        super(z10);
    }

    public c(boolean z10, ConfigRule configRule) {
        super(z10);
        this.f37660a = configRule;
    }

    public ConfigRule a() {
        try {
            return this.f37660a;
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
