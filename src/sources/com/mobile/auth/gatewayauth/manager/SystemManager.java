package com.mobile.auth.gatewayauth.manager;

import android.content.Context;
import android.os.Debug;
import android.os.Looper;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.manager.base.Cache;
import com.mobile.auth.gatewayauth.manager.base.CacheKey;
import com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor;
import com.mobile.auth.gatewayauth.model.TokenRet;
import com.mobile.auth.gatewayauth.utils.Checker;
import com.mobile.auth.gatewayauth.utils.i;
import com.mobile.auth.gatewayauth.utils.security.CheckProxy;
import com.mobile.auth.gatewayauth.utils.security.CheckRoot;
import com.mobile.auth.gatewayauth.utils.security.EmulatorDetector;
import com.mobile.auth.gatewayauth.utils.security.PackageUtils;
import com.nirvana.tools.core.CryptUtil;
import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SystemManager {

    /* renamed from: a, reason: collision with root package name */
    private final Context f37160a;

    /* renamed from: b, reason: collision with root package name */
    private String f37161b;

    /* renamed from: c, reason: collision with root package name */
    private String f37162c;

    /* renamed from: d, reason: collision with root package name */
    private final com.mobile.auth.q.a f37163d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f37164e = true;

    /* renamed from: f, reason: collision with root package name */
    private Future<?> f37165f;

    /* renamed from: com.mobile.auth.gatewayauth.manager.SystemManager$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 extends Callback<com.mobile.auth.w.d> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuffer f37168a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f37169b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ThreadStrategy threadStrategy, long j10, StringBuffer stringBuffer, CountDownLatch countDownLatch) {
            super(threadStrategy, j10);
            this.f37168a = stringBuffer;
            this.f37169b = countDownLatch;
        }

        public void a(com.mobile.auth.w.d dVar) {
            try {
                if (dVar.a() != null) {
                    this.f37168a.append(dVar.a());
                }
                this.f37169b.countDown();
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.d dVar) {
            try {
                a(dVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    public SystemManager(final Context context, com.mobile.auth.q.a aVar) {
        this.f37160a = context.getApplicationContext();
        this.f37165f = ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.manager.SystemManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SystemManager.a(SystemManager.this, PackageUtils.getPackageName(context));
                    SystemManager.b(SystemManager.this, PackageUtils.getSign(context));
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }
        });
        this.f37163d = aVar;
    }

    private TokenRet a(ResultCodeProcessor resultCodeProcessor, String str) {
        try {
            if (!com.mobile.auth.gatewayauth.utils.c.f(this.f37160a)) {
                return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_NO_SIM_FAIL, "SIM卡无法检测", str);
            }
            if (com.mobile.auth.gatewayauth.utils.c.e(this.f37160a)) {
                return null;
            }
            return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_NO_MOBILE_NETWORK_FAIL, "移动网络未开启", str);
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

    public static /* synthetic */ String a(SystemManager systemManager, String str) {
        try {
            systemManager.f37161b = str;
            return str;
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

    public static /* synthetic */ String b(SystemManager systemManager, String str) {
        try {
            systemManager.f37162c = str;
            return str;
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

    @SafeProtector
    private native String requestCellularIp();

    public TokenRet a(ResultCodeProcessor resultCodeProcessor, boolean z10, String str) {
        try {
            TokenRet checkEnvSafe = checkEnvSafe(resultCodeProcessor, str);
            return (checkEnvSafe == null && z10) ? a(resultCodeProcessor, str) : checkEnvSafe;
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

    public synchronized String a() {
        try {
            Future<?> future = this.f37165f;
            if (future != null) {
                try {
                    future.get();
                    this.f37165f = null;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return this.f37161b;
    }

    public void a(String str) {
        try {
            if ((FeatureManager.getInstance().get(FeatureManager.FEATURE_KEY_WHITE_CHECK) == null || !"false".equals(FeatureManager.getInstance().get(FeatureManager.FEATURE_KEY_WHITE_CHECK).toString())) && !TextUtils.isEmpty(str)) {
                AutoCloseable autoCloseable = null;
                try {
                    try {
                        String md5Hex = CryptUtil.md5Hex(str);
                        if (TextUtils.isEmpty(md5Hex)) {
                            this.f37164e = true;
                            return;
                        }
                        InputStream open = this.f37160a.getAssets().open(md5Hex);
                        this.f37164e = false;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception unused) {
                        this.f37164e = true;
                        if (0 != 0) {
                            try {
                                autoCloseable.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                } finally {
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

    public synchronized <T> boolean a(String str, Cache<T> cache, long j10) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (cache != null && cache.getKey() != null && cache.getKey().equals(str) && cache.getExpiredTime() - j10 > currentTimeMillis) {
                return true;
            }
            if (cache != null) {
                this.f37163d.a("ExpiredTime:", String.valueOf(cache.getExpiredTime()), "|threshold:", String.valueOf(j10), "|currTime:", String.valueOf(currentTimeMillis));
            }
            return false;
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

    public synchronized String b() {
        try {
            Future<?> future = this.f37165f;
            if (future != null) {
                try {
                    future.get();
                    this.f37165f = null;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return this.f37162c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r1 == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r1 == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return "unknown";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        return com.mobile.auth.gatewayauth.Constant.CTCC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        return com.mobile.auth.gatewayauth.Constant.CUCC;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "unknown"
            if (r7 != 0) goto L5
            return r0
        L5:
            r1 = -1
            int r2 = r7.hashCode()     // Catch: java.lang.Throwable -> L49
            r3 = -1350608857(0xffffffffaf7f5827, float:-2.3223433E-10)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L30
            r3 = 95009260(0x5a9b9ec, float:1.596098E-35)
            if (r2 == r3) goto L26
            r3 = 880617272(0x347d2738, float:2.3576729E-7)
            if (r2 == r3) goto L1c
            goto L39
        L1c:
            java.lang.String r2 = "cm_zyhl"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L49
            if (r7 == 0) goto L39
            r1 = 0
            goto L39
        L26:
            java.lang.String r2 = "cu_xw"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L49
            if (r7 == 0) goto L39
            r1 = 1
            goto L39
        L30:
            java.lang.String r2 = "ct_sjl"
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> L49
            if (r7 == 0) goto L39
            r1 = 2
        L39:
            if (r1 == 0) goto L46
            if (r1 == r5) goto L43
            if (r1 == r4) goto L40
            return r0
        L40:
            java.lang.String r7 = "CTCC"
            return r7
        L43:
            java.lang.String r7 = "CUCC"
            return r7
        L46:
            java.lang.String r7 = "CMCC"
            return r7
        L49:
            r7 = move-exception
            r0 = 0
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r7)     // Catch: java.lang.Throwable -> L4f
            return r0
        L4f:
            r7 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.manager.SystemManager.b(java.lang.String):java.lang.String");
    }

    public String c() {
        try {
            return com.mobile.auth.gatewayauth.utils.c.b(this.f37160a);
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

    public String c(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_SDK_PRE_LOGIN_CODE;
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

    @SafeProtector
    public TokenRet checkEnvSafe(ResultCodeProcessor resultCodeProcessor, String str) {
        try {
            try {
                if (this.f37164e) {
                    String c4 = Checker.c();
                    if (!TextUtils.isEmpty(c4) && !"0".equals(c4)) {
                        return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "手机终端不安全:the app is attached, please use safe phone!", str);
                    }
                }
                String isDeviceRooted = CheckRoot.isDeviceRooted();
                if (!TextUtils.isEmpty(isDeviceRooted)) {
                    return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "手机终端不安全:the phone is root, " + isDeviceRooted, str);
                }
                if (Thread.currentThread() == Looper.getMainLooper().getThread() && EmulatorDetector.isEmulator(this.f37160a)) {
                    return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "手机终端不安全:Emulator is detected, please use real phone!", str);
                }
                if (CheckProxy.isDevicedProxy(this.f37160a)) {
                    return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "手机终端不安全:the phone is proxy, please do not proxy!", str);
                }
                if (!Debug.isDebuggerConnected() || i.a()) {
                    return null;
                }
                return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "手机终端不安全:the app is debuggerConnected, please do not debug!", str);
            } catch (Exception e2) {
                return resultCodeProcessor.convertErrorInfo(Constant.CODE_ERROR_PHONE_UNSAFE_FAIL, "无法判运营商: " + e2.getMessage(), str);
            }
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

    public String d() {
        try {
            return com.mobile.auth.gatewayauth.utils.c.c(this.f37160a);
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

    public String d(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_SDK_PRE_AUTH_CODE;
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

    @SafeProtector
    public native synchronized String decryptContent(String str);

    public Context e() {
        try {
            return this.f37160a;
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

    public String e(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_SDK_LOGIN_CODE;
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

    @SafeProtector
    public native synchronized String encryptContent(String str);

    public String f(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_SDK_LOGIN_TOKEN;
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

    public String g(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_SDK_AUTH_TOKEN;
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

    @SafeProtector
    public native CacheKey getSimCacheKey(boolean z10, String str);

    @SafeProtector
    public native CacheKey getVendorCacheKey(String str);

    public String h(String str) {
        try {
            return b(str).toLowerCase() + Constant.ACTION_AUTH_PAGE_LOGIN;
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

    public String i(String str) {
        try {
            return Constant.ACTION_SDK + b(str).toLowerCase() + Constant.ACTION_AUTH_PAGE_PRIVACYALERT;
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

    public String j(String str) {
        try {
            return b(str).toLowerCase() + Constant.ACTION_AUTH_PAGE_RETURN;
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

    public String k(String str) {
        try {
            return b(str).toLowerCase() + Constant.ACTION_CLICK_PRIVACYALERT_PRIVACY;
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

    public String l(String str) {
        try {
            return b(str).toLowerCase() + Constant.ACTION_AUTH_PAGE_PROTOCOL;
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

    public String m(String str) {
        try {
            return b(str).toLowerCase() + Constant.ACTION_AUTH_PAGE_START;
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
