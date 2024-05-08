package com.mobile.auth.p;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.PnsLoggerHandler;
import com.mobile.auth.gatewayauth.PnsReporter;
import com.mobile.auth.gatewayauth.manager.d;
import com.mobile.auth.gatewayauth.manager.f;
import com.mobile.auth.gatewayauth.utils.i;
import com.nirvana.tools.logger.utils.ConsoleLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements PnsReporter {

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.q.a f37539a;

    /* renamed from: b, reason: collision with root package name */
    private d f37540b;

    /* renamed from: c, reason: collision with root package name */
    private f f37541c;

    public a(com.mobile.auth.q.a aVar, d dVar) {
        this.f37539a = aVar;
        this.f37540b = dVar;
    }

    public void a(f fVar) {
        try {
            this.f37541c = fVar;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.PnsReporter
    public void setLogExtension(String str) {
        try {
            this.f37540b.c(str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.PnsReporter
    public void setLoggerEnable(boolean z10) {
        try {
            System.currentTimeMillis();
            i.a(z10);
            ConsoleLogUtils.setLoggerEnable(z10);
            f fVar = this.f37541c;
            if (fVar != null) {
                for (com.mobile.auth.gatewayauth.manager.a aVar : fVar.a()) {
                    if (aVar != null) {
                        aVar.a(z10);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.PnsReporter
    public void setLoggerHandler(PnsLoggerHandler pnsLoggerHandler) {
        try {
            this.f37539a.a(pnsLoggerHandler);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.PnsReporter
    public void setUploadEnable(boolean z10) {
        try {
            System.currentTimeMillis();
            i.b(z10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
