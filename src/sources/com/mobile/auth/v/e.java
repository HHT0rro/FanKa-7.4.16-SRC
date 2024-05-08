package com.mobile.auth.v;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.manager.a;
import com.mobile.auth.w.f;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.Request;
import com.nirvana.tools.requestqueue.strategy.CallbackStrategy;
import com.nirvana.tools.requestqueue.strategy.ExecuteStrategy;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e extends Request<f> {

    /* renamed from: a, reason: collision with root package name */
    private String f37654a;

    public e(com.mobile.auth.gatewayauth.manager.f fVar, Callback<f> callback, long j10, String str, a.b bVar) {
        super(callback, new com.mobile.auth.r.f(fVar, str, bVar, j10), ThreadStrategy.THREAD, ExecuteStrategy.USE_PREV, CallbackStrategy.LIST, j10, f.class);
        this.f37654a = bVar.b();
    }

    @Override // com.nirvana.tools.requestqueue.Request
    public String getKey() {
        try {
            return this.f37654a;
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
