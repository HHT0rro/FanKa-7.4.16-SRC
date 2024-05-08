package com.mobile.auth.v;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.Request;
import com.nirvana.tools.requestqueue.strategy.CallbackStrategy;
import com.nirvana.tools.requestqueue.strategy.ExecuteStrategy;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends Request<com.mobile.auth.w.a> {
    public d(Callback<com.mobile.auth.w.a> callback, com.mobile.auth.r.a aVar) {
        super(callback, aVar, ThreadStrategy.THREAD, ExecuteStrategy.USE_PREV, CallbackStrategy.LIST, 5000L, com.mobile.auth.w.a.class);
    }

    public static synchronized String a() {
        String uuid;
        synchronized (d.class) {
            try {
                uuid = UUID.randomUUID().toString();
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
        return uuid;
    }

    @Override // com.nirvana.tools.requestqueue.Request
    public String getKey() {
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
