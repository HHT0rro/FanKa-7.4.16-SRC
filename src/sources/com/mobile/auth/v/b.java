package com.mobile.auth.v;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.Request;
import com.nirvana.tools.requestqueue.TimeoutCallable;
import com.nirvana.tools.requestqueue.strategy.CallbackStrategy;
import com.nirvana.tools.requestqueue.strategy.ExecuteStrategy;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends Request<com.mobile.auth.w.d> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37652a = "com.mobile.auth.v.b";

    public b(Callback<com.mobile.auth.w.d> callback, TimeoutCallable<com.mobile.auth.w.d> timeoutCallable) {
        super(callback, timeoutCallable, ThreadStrategy.THREAD, ExecuteStrategy.USE_PREV, CallbackStrategy.LIST, 500L, com.mobile.auth.w.d.class);
    }

    @Override // com.nirvana.tools.requestqueue.Request
    public String getKey() {
        try {
            return f37652a;
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
