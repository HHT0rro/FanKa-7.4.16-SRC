package com.mobile.auth.r;

import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.manager.RequestCallback;
import com.mobile.auth.gatewayauth.manager.a;
import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.requestqueue.TimeoutCallable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class e implements TimeoutCallable<com.mobile.auth.w.e> {

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.gatewayauth.manager.f f37586a;

    /* renamed from: b, reason: collision with root package name */
    private String f37587b;

    /* renamed from: c, reason: collision with root package name */
    private long f37588c;

    /* renamed from: d, reason: collision with root package name */
    private String f37589d;

    public e(com.mobile.auth.gatewayauth.manager.f fVar, String str, long j10, String str2) {
        this.f37586a = fVar;
        this.f37587b = str;
        this.f37588c = j10;
        this.f37589d = str2;
    }

    public com.mobile.auth.w.e a() {
        try {
            com.mobile.auth.w.e eVar = new com.mobile.auth.w.e(true);
            eVar.a(com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_FUNCTION_TIME_OUT, "请求超时"));
            return eVar;
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

    public abstract void a(RequestCallback requestCallback, com.mobile.auth.gatewayauth.manager.a aVar);

    public com.mobile.auth.w.e b() {
        try {
            com.mobile.auth.gatewayauth.utils.e.a().a(this.f37589d, "doRequest", System.currentTimeMillis());
            com.mobile.auth.gatewayauth.manager.a a10 = this.f37586a.a(this.f37587b);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final com.mobile.auth.w.e eVar = new com.mobile.auth.w.e(false);
            a(new RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.r.e.1
                public void a(a.C0558a c0558a) {
                    try {
                        eVar.a(true);
                        eVar.a(c0558a);
                        eVar.a(com.mobile.auth.gatewayauth.manager.base.b.a().c(c0558a.c()).a(c0558a.d()).a());
                        countDownLatch.countDown();
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        eVar.a(bVar);
                        countDownLatch.countDown();
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onError(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        a(bVar);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                public /* synthetic */ void onSuccess(a.C0558a c0558a) {
                    try {
                        a(c0558a);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, a10);
            try {
                long j10 = this.f37588c;
                if (j10 <= 5000) {
                    j10 = 5000;
                }
                countDownLatch.await(j10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                eVar.a(com.mobile.auth.gatewayauth.manager.base.b.a(Constant.CODE_ERROR_UNKNOWN_FAIL, ExecutorManager.getErrorInfoFromException(e2)));
            }
            return eVar;
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
    public /* synthetic */ com.mobile.auth.w.e onTimeout() {
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
