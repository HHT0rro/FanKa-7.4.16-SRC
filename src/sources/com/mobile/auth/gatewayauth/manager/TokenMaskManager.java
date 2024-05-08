package com.mobile.auth.gatewayauth.manager;

import android.text.TextUtils;
import android.util.LruCache;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.manager.a;
import com.mobile.auth.gatewayauth.manager.base.Cache;
import com.mobile.auth.gatewayauth.manager.base.CacheKey;
import com.mobile.auth.gatewayauth.model.LoginPhoneInfo;
import com.mobile.auth.gatewayauth.utils.TokenGenerator;
import com.mobile.auth.gatewayauth.utils.g;
import com.nirvana.tools.cache.CacheHandler;
import com.nirvana.tools.cache.CacheManager;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TokenMaskManager {

    /* renamed from: a, reason: collision with root package name */
    private b f37171a;

    /* renamed from: b, reason: collision with root package name */
    private SystemManager f37172b;

    /* renamed from: c, reason: collision with root package name */
    private d f37173c;

    /* renamed from: d, reason: collision with root package name */
    private VendorSdkInfoManager f37174d;

    /* renamed from: e, reason: collision with root package name */
    private f f37175e;

    /* renamed from: f, reason: collision with root package name */
    private TokenGenerator f37176f;

    /* renamed from: g, reason: collision with root package name */
    private com.mobile.auth.q.a f37177g;

    /* renamed from: h, reason: collision with root package name */
    private volatile Map<String, LoginPhoneInfo> f37178h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private volatile Cache<LoginPhoneInfo> f37179i = null;

    /* renamed from: j, reason: collision with root package name */
    private volatile LruCache<String, Cache<String>> f37180j = new LruCache<>(10);

    /* renamed from: k, reason: collision with root package name */
    private volatile LruCache<String, Cache<String>> f37181k = new LruCache<>(10);

    /* renamed from: l, reason: collision with root package name */
    private CacheHandler f37182l;

    /* renamed from: m, reason: collision with root package name */
    private CacheHandler f37183m;

    /* renamed from: n, reason: collision with root package name */
    private CacheHandler f37184n;

    /* renamed from: o, reason: collision with root package name */
    private CacheHandler f37185o;

    /* renamed from: p, reason: collision with root package name */
    private CacheManager f37186p;

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$11, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass11 extends Callback<com.mobile.auth.w.e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f37194a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass11(ThreadStrategy threadStrategy, long j10, RequestCallback requestCallback) {
            super(threadStrategy, j10);
            this.f37194a = requestCallback;
        }

        public void a(com.mobile.auth.w.e eVar) {
            try {
                if (eVar.a()) {
                    this.f37194a.onSuccess(eVar);
                    return;
                }
                com.mobile.auth.gatewayauth.manager.base.b b4 = eVar.b();
                if (b4 == null) {
                    b4 = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                }
                this.f37194a.onError(b4);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.e eVar) {
            try {
                a(eVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$12, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass12 extends com.mobile.auth.r.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37196a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37197b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass12(f fVar, String str, long j10, String str2, String str3, String str4) {
            super(fVar, str, j10, str2);
            this.f37196a = str3;
            this.f37197b = str4;
        }

        @Override // com.mobile.auth.r.e
        public void a(RequestCallback requestCallback, a aVar) {
            try {
                aVar.a((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, a.b.a().a(this.f37196a).b(this.f37197b).a());
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$13, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass13 extends Callback<com.mobile.auth.w.e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37199a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37200b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CacheKey f37201c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f37202d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass13(ThreadStrategy threadStrategy, long j10, String str, String str2, CacheKey cacheKey, RequestCallback requestCallback) {
            super(threadStrategy, j10);
            this.f37199a = str;
            this.f37200b = str2;
            this.f37201c = cacheKey;
            this.f37202d = requestCallback;
        }

        public void a(com.mobile.auth.w.e eVar) {
            try {
                TokenMaskManager.d(TokenMaskManager.this).a("Update LoginToken from network!");
                if (eVar.a()) {
                    eVar.b().a(Math.min(System.currentTimeMillis() + 86400000, eVar.b().f()));
                    TokenMaskManager.a(TokenMaskManager.this, this.f37199a, this.f37200b, this.f37201c, eVar.b().d(), eVar.b().f());
                    this.f37202d.onSuccess("false");
                } else {
                    com.mobile.auth.gatewayauth.manager.base.b b4 = eVar.b();
                    if (b4 == null) {
                        b4 = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                    }
                    this.f37202d.onError(b4);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.e eVar) {
            try {
                a(eVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$14, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass14 extends com.mobile.auth.r.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37204a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37205b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass14(f fVar, String str, long j10, String str2, String str3, String str4) {
            super(fVar, str, j10, str2);
            this.f37204a = str3;
            this.f37205b = str4;
        }

        @Override // com.mobile.auth.r.e
        public void a(RequestCallback requestCallback, a aVar) {
            try {
                aVar.b((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, a.b.a().a(this.f37204a).b(this.f37205b).a());
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$15, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass15 extends Callback<com.mobile.auth.w.e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37207a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f37208b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass15(ThreadStrategy threadStrategy, long j10, String str, RequestCallback requestCallback) {
            super(threadStrategy, j10);
            this.f37207a = str;
            this.f37208b = requestCallback;
        }

        public void a(com.mobile.auth.w.e eVar) {
            try {
                TokenMaskManager.d(TokenMaskManager.this).a("Update LoginToken from network!");
                if (eVar.a()) {
                    eVar.b().a(TokenMaskManager.a(TokenMaskManager.this, eVar.b().d(), this.f37207a, true));
                    this.f37208b.onSuccess(eVar.b());
                } else {
                    com.mobile.auth.gatewayauth.manager.base.b b4 = eVar.b();
                    if (b4 == null) {
                        b4 = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                    }
                    this.f37208b.onError(b4);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.e eVar) {
            try {
                a(eVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$16, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass16 extends com.mobile.auth.r.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37210a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37211b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass16(f fVar, String str, long j10, String str2, String str3, String str4) {
            super(fVar, str, j10, str2);
            this.f37210a = str3;
            this.f37211b = str4;
        }

        @Override // com.mobile.auth.r.e
        public void a(RequestCallback requestCallback, a aVar) {
            try {
                aVar.b((RequestCallback<a.C0558a, com.mobile.auth.gatewayauth.manager.base.b>) requestCallback, a.b.a().a(this.f37210a).b(this.f37211b).a());
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 extends Callback<com.mobile.auth.w.f> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37213a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f37214b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ThreadStrategy threadStrategy, long j10, String str, RequestCallback requestCallback) {
            super(threadStrategy, j10);
            this.f37213a = str;
            this.f37214b = requestCallback;
        }

        public void a(com.mobile.auth.w.f fVar) {
            try {
                TokenMaskManager.d(TokenMaskManager.this).a("Update VerifyToken from network!");
                if (fVar.a()) {
                    fVar.b().a(TokenMaskManager.a(TokenMaskManager.this, fVar.b().d(), this.f37213a, false));
                    this.f37214b.onSuccess(fVar.b());
                } else {
                    com.mobile.auth.gatewayauth.manager.base.b b4 = fVar.b();
                    if (b4 == null) {
                        b4 = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                    }
                    this.f37214b.onError(b4);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.f fVar) {
            try {
                a(fVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass3 extends Callback<com.mobile.auth.w.f> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37216a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37217b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CacheKey f37218c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RequestCallback f37219d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ThreadStrategy threadStrategy, long j10, String str, String str2, CacheKey cacheKey, RequestCallback requestCallback) {
            super(threadStrategy, j10);
            this.f37216a = str;
            this.f37217b = str2;
            this.f37218c = cacheKey;
            this.f37219d = requestCallback;
        }

        public void a(com.mobile.auth.w.f fVar) {
            try {
                TokenMaskManager.d(TokenMaskManager.this).a("Update VerifyToken from network!");
                if (fVar.a()) {
                    fVar.b().a(Math.min(System.currentTimeMillis() + 86400000, fVar.b().f()));
                    TokenMaskManager.b(TokenMaskManager.this, this.f37216a, this.f37217b, this.f37218c, fVar.b().d(), fVar.b().f());
                    this.f37219d.onSuccess("false");
                } else {
                    com.mobile.auth.gatewayauth.manager.base.b b4 = fVar.b();
                    if (b4 == null) {
                        b4 = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                    }
                    this.f37219d.onError(b4);
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        @Override // com.nirvana.tools.requestqueue.Callback
        public /* synthetic */ void onResult(com.mobile.auth.w.f fVar) {
            try {
                a(fVar);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 extends JsonType<LoginPhoneInfo> {
        public AnonymousClass4() {
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$5, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass5 extends JsonType<String> {
        public AnonymousClass5() {
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$6, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass6 extends JsonType<String> {
        public AnonymousClass6() {
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$7, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TokenMaskManager.g(TokenMaskManager.this).save(TokenMaskManager.f(TokenMaskManager.this).encryptContent(TokenMaskManager.e(TokenMaskManager.this).toJson().toString()));
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.manager.TokenMaskManager$8, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f37225a;

        public AnonymousClass8(JSONObject jSONObject) {
            this.f37225a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TokenMaskManager.h(TokenMaskManager.this).save(TokenMaskManager.f(TokenMaskManager.this).encryptContent(this.f37225a.toString()));
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

    public TokenMaskManager(b bVar, SystemManager systemManager, d dVar, f fVar, VendorSdkInfoManager vendorSdkInfoManager) {
        this.f37171a = bVar;
        this.f37172b = systemManager;
        this.f37173c = dVar;
        this.f37177g = dVar.a();
        this.f37174d = vendorSdkInfoManager;
        this.f37175e = fVar;
        this.f37176f = new TokenGenerator(this.f37177g, this.f37172b, this.f37174d);
        this.f37186p = CacheManager.getInstance(this.f37172b.e());
        b();
        g.a(new Runnable() { // from class: com.mobile.auth.gatewayauth.manager.TokenMaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TokenMaskManager.a(TokenMaskManager.this);
                    TokenMaskManager.b(TokenMaskManager.this);
                    TokenMaskManager.c(TokenMaskManager.this);
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }
        });
    }

    public static /* synthetic */ String a(TokenMaskManager tokenMaskManager, String str, String str2, boolean z10) {
        try {
            return tokenMaskManager.a(str, str2, z10);
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

    private native String a(String str, CacheKey cacheKey, long j10);

    private native String a(String str, String str2, CacheKey cacheKey, long j10);

    private native String a(String str, String str2, boolean z10);

    public static /* synthetic */ void a(TokenMaskManager tokenMaskManager) {
        try {
            tokenMaskManager.c();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(TokenMaskManager tokenMaskManager, CacheKey cacheKey, LoginPhoneInfo loginPhoneInfo, String str) {
        try {
            tokenMaskManager.a(cacheKey, loginPhoneInfo, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(TokenMaskManager tokenMaskManager, String str, String str2, CacheKey cacheKey, String str3, long j10) {
        try {
            tokenMaskManager.b(str, str2, cacheKey, str3, j10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private native synchronized void a(CacheKey cacheKey, LoginPhoneInfo loginPhoneInfo, String str);

    private native synchronized void a(String str, String str2, CacheKey cacheKey, String str3, long j10);

    private native boolean a(String str, String str2, long j10);

    private native synchronized boolean a(String str, String str2, LruCache<String, Cache<String>> lruCache, long j10);

    private native void b();

    public static /* synthetic */ void b(TokenMaskManager tokenMaskManager) {
        try {
            tokenMaskManager.d();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void b(TokenMaskManager tokenMaskManager, String str, String str2, CacheKey cacheKey, String str3, long j10) {
        try {
            tokenMaskManager.a(str, str2, cacheKey, str3, j10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private native synchronized void b(String str, String str2, CacheKey cacheKey, String str3, long j10);

    private native boolean b(CacheKey cacheKey);

    private native boolean b(String str, String str2, long j10);

    private native synchronized void c();

    public static /* synthetic */ void c(TokenMaskManager tokenMaskManager) {
        try {
            tokenMaskManager.e();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a d(TokenMaskManager tokenMaskManager) {
        try {
            return tokenMaskManager.f37177g;
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

    private native synchronized void d();

    public static /* synthetic */ Cache e(TokenMaskManager tokenMaskManager) {
        try {
            return tokenMaskManager.f37179i;
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

    private native synchronized void e();

    public static /* synthetic */ SystemManager f(TokenMaskManager tokenMaskManager) {
        try {
            return tokenMaskManager.f37172b;
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

    private native synchronized void f();

    public static /* synthetic */ CacheHandler g(TokenMaskManager tokenMaskManager) {
        try {
            return tokenMaskManager.f37185o;
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

    private native synchronized void g();

    public static /* synthetic */ CacheHandler h(TokenMaskManager tokenMaskManager) {
        try {
            return tokenMaskManager.f37184n;
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

    private native synchronized void h();

    @SafeProtector
    private native synchronized String popToken(String str, CacheKey cacheKey, CacheHandler cacheHandler, LruCache<String, Cache<String>> lruCache, long j10);

    @SafeProtector
    private native void requestMask(long j10, String str, RequestCallback<com.mobile.auth.w.e, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, CacheKey cacheKey, String str2, int i10, String str3, String str4);

    public native LoginPhoneInfo a(CacheKey cacheKey);

    public native synchronized void a();

    public native void a(long j10, String str, RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, CacheKey cacheKey, long j11, String str2, String str3, String str4);

    public native void a(long j10, String str, RequestCallback<String, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, CacheKey cacheKey, String str2, long j11, int i10, String str3, String str4);

    public native void b(long j10, String str, RequestCallback<String, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, CacheKey cacheKey, long j11, String str2, String str3, String str4);

    public native void b(long j10, String str, RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, CacheKey cacheKey, String str2, long j11, int i10, String str3, String str4);

    @SafeProtector
    public void updateMask(long j10, final String str, final RequestCallback<com.mobile.auth.gatewayauth.manager.base.b, com.mobile.auth.gatewayauth.manager.base.b> requestCallback, final CacheKey cacheKey, int i10, final String str2, String str3, String str4) {
        if (requestCallback == null) {
            return;
        }
        try {
            if (this.f37171a.c()) {
                requestCallback.onError(com.mobile.auth.gatewayauth.manager.base.b.a(Constant.CODE_ERROR_FUNCTION_DEMOTE, "系统维护，功能不可用"));
                return;
            }
            LoginPhoneInfo a10 = a(cacheKey);
            com.mobile.auth.gatewayauth.utils.e.a().a(str3, "maskCache", System.currentTimeMillis());
            final CacheKey vendorCacheKey = this.f37172b.getVendorCacheKey(str);
            long a11 = c.a(str);
            com.mobile.auth.q.a aVar = this.f37177g;
            String[] strArr = new String[3];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("HasMaskCache:");
            sb2.append(a10 != null);
            strArr[0] = sb2.toString();
            strArr[1] = ", SimKey:";
            strArr[2] = cacheKey.toString();
            aVar.a(strArr);
            if (a10 == null) {
                requestMask(j10, str, new RequestCallback<com.mobile.auth.w.e, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.gatewayauth.manager.TokenMaskManager.10
                    public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                        if (bVar == null) {
                            try {
                                bVar = com.mobile.auth.gatewayauth.manager.base.b.a(ResultCode.CODE_ERROR_UNKNOWN_FAIL, "未知异常");
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                    return;
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                    return;
                                }
                            }
                        }
                        requestCallback.onError(bVar);
                    }

                    public void a(com.mobile.auth.w.e eVar) {
                        try {
                            LoginPhoneInfo build = LoginPhoneInfo.newLoginPhoneInfo().protocolName(eVar.c().e()).protocolUrl(eVar.c().f()).phoneNumber(eVar.c().b()).build();
                            TokenMaskManager.a(TokenMaskManager.this, cacheKey, build, str);
                            requestCallback.onSuccess(com.mobile.auth.gatewayauth.manager.base.b.a().a(false).a(build).a());
                            eVar.b().a(Math.min(System.currentTimeMillis() + 86400000, eVar.b().f()));
                            if (TextUtils.isEmpty(eVar.b().d())) {
                                return;
                            }
                            TokenMaskManager.a(TokenMaskManager.this, str2, str, vendorCacheKey, eVar.b().d(), eVar.b().f());
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
                    public /* synthetic */ void onSuccess(com.mobile.auth.w.e eVar) {
                        try {
                            a(eVar);
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                            }
                        }
                    }
                }, cacheKey, str2, i10, str3, str4);
                return;
            }
            requestCallback.onSuccess(com.mobile.auth.gatewayauth.manager.base.b.a().a(true).a(a10).a());
            if (Constant.VENDOR_CMCC.equals(str) || a(str2, vendorCacheKey.getKey(), a11)) {
                return;
            }
            a(j10, str, new RequestCallback<String, com.mobile.auth.gatewayauth.manager.base.b>() { // from class: com.mobile.auth.gatewayauth.manager.TokenMaskManager.9
                public void a(com.mobile.auth.gatewayauth.manager.base.b bVar) {
                    try {
                        com.mobile.auth.q.a d10 = TokenMaskManager.d(TokenMaskManager.this);
                        String[] strArr2 = new String[2];
                        strArr2[0] = "Update LoginToken failed when update mask!";
                        strArr2[1] = bVar == null ? "" : bVar.toString();
                        d10.e(strArr2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void a(String str5) {
                    try {
                        TokenMaskManager.d(TokenMaskManager.this).a("Update LoginToken success when update mask!");
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
                public /* synthetic */ void onSuccess(String str5) {
                    try {
                        a(str5);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, vendorCacheKey, str2, a11, i10, str3, str4);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
