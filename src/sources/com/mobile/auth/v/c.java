package com.mobile.auth.v;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.Request;
import com.nirvana.tools.requestqueue.strategy.CallbackStrategy;
import com.nirvana.tools.requestqueue.strategy.ExecuteStrategy;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends Request<com.mobile.auth.w.e> {

    /* renamed from: a, reason: collision with root package name */
    private String f37653a;

    public c(com.mobile.auth.r.e eVar, Callback<com.mobile.auth.w.e> callback, long j10, String str) {
        super(callback, eVar, ThreadStrategy.THREAD, ExecuteStrategy.USE_PREV, CallbackStrategy.LIST, j10, com.mobile.auth.w.e.class);
        this.f37653a = str;
    }

    @Override // com.nirvana.tools.requestqueue.Request
    public String getKey() {
        try {
            return this.f37653a;
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
