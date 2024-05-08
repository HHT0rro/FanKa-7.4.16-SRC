package com.mobile.auth.gatewayauth.utils;

import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.TokenResultListener;
import com.mobile.auth.gatewayauth.model.TokenRet;
import com.nirvana.tools.core.ExecutorManager;
import java.lang.Thread;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f37385a;

        public a() {
            this.f37385a = new Thread.UncaughtExceptionHandler() { // from class: com.mobile.auth.gatewayauth.utils.g.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    try {
                        i.c("未知异常:" + ExecutorManager.getErrorInfoFromException(th));
                    } catch (Throwable th2) {
                        try {
                            ExceptionProcessor.processException(th2);
                        } catch (Throwable th3) {
                            ExceptionProcessor.processException(th3);
                        }
                    }
                }
            };
        }

        public a(final TokenResultListener tokenResultListener) {
            this.f37385a = new Thread.UncaughtExceptionHandler() { // from class: com.mobile.auth.gatewayauth.utils.g.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, final Throwable th) {
                    try {
                        g.a(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.utils.g.a.2.1
                            @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                            public void onException(Throwable th2) {
                            }

                            @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                            public void safeRun() {
                                try {
                                    TokenResultListener tokenResultListener2 = tokenResultListener;
                                    if (tokenResultListener2 != null) {
                                        tokenResultListener2.onTokenFailed(g.a(th));
                                    } else {
                                        i.a(th);
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        ExceptionProcessor.processException(th2);
                                    } catch (Throwable th3) {
                                        ExceptionProcessor.processException(th3);
                                    }
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        try {
                            ExceptionProcessor.processException(th2);
                        } catch (Throwable th3) {
                            ExceptionProcessor.processException(th3);
                        }
                    }
                }
            };
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.currentThread().setUncaughtExceptionHandler(this.f37385a);
                a();
                Thread.currentThread().setUncaughtExceptionHandler(null);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static String a(Throwable th) {
        try {
            TokenRet tokenRet = new TokenRet();
            tokenRet.setCode(com.mobile.auth.gatewayauth.utils.a.f37377a ? ResultCode.CODE_ERROR_UNKNOWN_FAIL : Constant.CODE_ERROR_UNKNOWN_FAIL);
            tokenRet.setMsg("未知异常:" + ExecutorManager.getErrorInfoFromException(th));
            return tokenRet.toJsonString();
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
                return null;
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
                return null;
            }
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return ExecutorManager.getInstance().scheduleFuture(runnable);
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

    public static void a(ExecutorManager.SafeRunnable safeRunnable) {
        try {
            ExecutorManager.getInstance().postMain(safeRunnable);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
