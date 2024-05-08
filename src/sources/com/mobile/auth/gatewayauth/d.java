package com.mobile.auth.gatewayauth;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.AuthUIConfig;
import com.mobile.auth.gatewayauth.activity.AuthWebVeiwActivity;
import com.mobile.auth.gatewayauth.manager.SystemManager;
import com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor;
import com.mobile.auth.gatewayauth.model.TokenRet;
import com.mobile.auth.gatewayauth.model.UStruct;
import com.mobile.auth.gatewayauth.utils.ReflectionUtils;
import com.mobile.auth.gatewayauth.utils.i;
import com.mobile.auth.gatewayauth.utils.l;
import com.nirvana.tools.core.AppUtils;
import com.nirvana.tools.core.ExecutorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private final Context f37068c;

    /* renamed from: d, reason: collision with root package name */
    private AuthUIControlClickListener f37069d;

    /* renamed from: e, reason: collision with root package name */
    private volatile WeakReference<Activity> f37070e;

    /* renamed from: f, reason: collision with root package name */
    private volatile WeakReference<Activity> f37071f;

    /* renamed from: g, reason: collision with root package name */
    private AuthUIConfig f37072g;

    /* renamed from: h, reason: collision with root package name */
    private LinkedHashMap<String, AuthRegisterViewConfig> f37073h;

    /* renamed from: i, reason: collision with root package name */
    private LinkedHashMap<String, AuthRegisterViewConfig> f37074i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<AuthRegisterXmlConfig> f37075j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<AuthRegisterXmlConfig> f37076k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<Object> f37077l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Object> f37078m;

    /* renamed from: o, reason: collision with root package name */
    private final com.mobile.auth.q.a f37080o;

    /* renamed from: p, reason: collision with root package name */
    private WeakReference<Activity> f37081p;

    /* renamed from: q, reason: collision with root package name */
    private TokenResultListener f37082q;

    /* renamed from: r, reason: collision with root package name */
    private ActivityResultListener f37083r;

    /* renamed from: s, reason: collision with root package name */
    private final PhoneNumberAuthHelper f37084s;

    /* renamed from: t, reason: collision with root package name */
    private final SystemManager f37085t;

    /* renamed from: u, reason: collision with root package name */
    private ResultCodeProcessor f37086u;

    /* renamed from: v, reason: collision with root package name */
    private final com.mobile.auth.gatewayauth.manager.d f37087v;

    /* renamed from: w, reason: collision with root package name */
    private long f37088w;

    /* renamed from: x, reason: collision with root package name */
    private long f37089x;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, d> f37067b = new ConcurrentHashMap<>(5);

    /* renamed from: a, reason: collision with root package name */
    public static final AuthUIConfig f37066a = new AuthUIConfig.Builder().create();

    /* renamed from: y, reason: collision with root package name */
    private volatile boolean f37090y = false;

    /* renamed from: z, reason: collision with root package name */
    private volatile boolean f37091z = false;
    private volatile boolean A = false;
    private volatile boolean B = false;
    private volatile boolean C = true;
    private volatile boolean D = false;
    private volatile boolean E = false;
    private final Application.ActivityLifecycleCallbacks F = new Application.ActivityLifecycleCallbacks() { // from class: com.mobile.auth.gatewayauth.d.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                d.this.a(activity);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Activity activity2;
            try {
                if ((activity instanceof LoginAuthActivity) && ((LoginAuthActivity) activity).getUIManagerID() == d.a(d.this) && d.b(d.this) != null && (activity2 = (Activity) d.b(d.this).get()) != null && activity2 == activity) {
                    Application application = ReflectionUtils.getApplication();
                    if (application != null) {
                        application.unregisterActivityLifecycleCallbacks(d.c(d.this));
                    }
                    d.a(d.this, (WeakReference) null);
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                if ((activity instanceof LoginAuthActivity) && ((LoginAuthActivity) activity).getUIManagerID() == d.a(d.this)) {
                    d.a(d.this, false);
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                if ((activity instanceof LoginAuthActivity) && ((LoginAuthActivity) activity).getUIManagerID() == d.a(d.this)) {
                    d.a(d.this, true);
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    };

    /* renamed from: n, reason: collision with root package name */
    private final int f37079n = hashCode();

    public d(Context context, com.mobile.auth.gatewayauth.manager.d dVar, SystemManager systemManager, PhoneNumberAuthHelper phoneNumberAuthHelper) {
        this.f37068c = context.getApplicationContext();
        this.f37087v = dVar;
        this.f37080o = dVar.a();
        this.f37085t = systemManager;
        this.f37084s = phoneNumberAuthHelper;
    }

    public static /* synthetic */ int a(d dVar) {
        try {
            return dVar.f37079n;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public static /* synthetic */ AuthUIConfig a(d dVar, AuthUIConfig authUIConfig) {
        try {
            dVar.f37072g = authUIConfig;
            return authUIConfig;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static d a(int i10) {
        try {
            return f37067b.get(Integer.valueOf(i10));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ WeakReference a(d dVar, WeakReference weakReference) {
        try {
            dVar.f37081p = weakReference;
            return weakReference;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static void a(AuthUIConfig authUIConfig, int i10, Activity activity) {
        try {
            if (authUIConfig.isStatusBarHidden()) {
                l.a(activity);
            } else {
                l.c(activity, authUIConfig.getStatusBarUIFlag());
            }
            l.a(activity, i10);
            l.b(activity, authUIConfig.getBottomNavBarColor());
            l.a(activity, authUIConfig.isLightColor());
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void a(final String str, final String str2, final String str3) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).sessionId(d.h(d.this).c()).authSdkCode(ResultCode.CODE_ERROR_USER_PROTOCOL_CONTROL).carrierUrl(str3).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void a(final String str, final String str2, final String str3, final String str4, final String str5) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).protocolName(str5).protocolUrl(str4).sessionId(d.h(d.this).c()).authSdkCode(d.i(d.this).convertCode(str3)).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void a(final String str, final String str2, final boolean z10) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).sessionId(d.h(d.this).c()).authSdkCode(ResultCode.CODE_START_AUTH_PRIVACY).isAuthPageLegal(String.valueOf(z10)).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void a(final String str, final String str2, boolean z10, final boolean z11) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).sessionId(d.h(d.this).c()).authSdkCode(ResultCode.CODE_ERROR_USER_LOGIN_BTN).isAuthPageLegal(String.valueOf(z11)).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void a(final boolean z10, final String str, final String str2, final boolean z11) {
        try {
            ExecutorManager.getInstance().postMain(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.d.6
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onException(Throwable th) {
                    try {
                        d.d(d.this).e("QuitActivity error!", ExecutorManager.getErrorInfoFromException(th));
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }

                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onFinal() {
                    try {
                        super.onFinal();
                        if (z11 && d.f(d.this) != null && z10) {
                            TokenRet convertErrorInfo = d.this.a().convertErrorInfo(str, str2, d.g(d.this).c());
                            convertErrorInfo.setVendorName(d.g(d.this).d());
                            convertErrorInfo.setRequestId(d.h(d.this).e());
                            d.f(d.this).onTokenFailed(convertErrorInfo.toJsonString());
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void safeRun() {
                    Activity activity;
                    try {
                        if (d.b(d.this) != null && (activity = (Activity) d.b(d.this).get()) != null) {
                            activity.finish();
                            d dVar = d.this;
                            d.a(dVar, dVar.q());
                            if (d.e(d.this).getAuthPageActOut() != null && d.e(d.this).getActivityIn() != null) {
                                activity.overridePendingTransition(AppUtils.getAnimResID(activity, d.e(d.this).getAuthPageActOut()), AppUtils.getAnimResID(activity, d.e(d.this).getActivityIn()));
                            }
                        }
                        d.this.A();
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        try {
            dVar.f37090y = z10;
            return z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public static /* synthetic */ WeakReference b(d dVar) {
        try {
            return dVar.f37081p;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ WeakReference b(d dVar, WeakReference weakReference) {
        try {
            dVar.f37071f = weakReference;
            return weakReference;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private void b(final String str, final String str2, final String str3) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).sessionId(d.h(d.this).c()).authSdkCode(d.i(d.this).convertCode(str3)).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ Application.ActivityLifecycleCallbacks c(d dVar) {
        try {
            return dVar.F;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private void c(final String str, final String str2, final String str3) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.d(d.this).a(d.h(d.this).b(str, str2, UStruct.newUStruct().startTime(d.j(d.this)).endTime(System.currentTimeMillis()).requestId(d.h(d.this).e()).suspendDisMissVC(d.k(d.this)).sessionId(d.h(d.this).c()).authSdkCode(d.i(d.this).convertCode(str3)).build(), ""), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a d(d dVar) {
        try {
            return dVar.f37080o;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ AuthUIConfig e(d dVar) {
        try {
            return dVar.f37072g;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ TokenResultListener f(d dVar) {
        try {
            return dVar.f37082q;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ SystemManager g(d dVar) {
        try {
            return dVar.f37085t;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ com.mobile.auth.gatewayauth.manager.d h(d dVar) {
        try {
            return dVar.f37087v;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ ResultCodeProcessor i(d dVar) {
        try {
            return dVar.f37086u;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ long j(d dVar) {
        try {
            return dVar.f37088w;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1L;
        }
    }

    public static /* synthetic */ boolean k(d dVar) {
        try {
            return dVar.D;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void A() {
        try {
            f37067b.remove(Integer.valueOf(this.f37079n));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public com.mobile.auth.q.a B() {
        try {
            return this.f37080o;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public boolean C() {
        try {
            return this.f37090y;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public ResultCodeProcessor a() {
        try {
            if (this.f37086u == null) {
                this.f37086u = new com.mobile.auth.gatewayauth.manager.compat.b();
            }
            return this.f37086u;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public void a(long j10) {
        try {
            this.f37088w = j10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0099 A[Catch: Exception -> 0x009d, all -> 0x00ac, TRY_LEAVE, TryCatch #0 {Exception -> 0x009d, blocks: (B:4:0x0028, B:6:0x003b, B:7:0x0045, B:9:0x0052, B:12:0x005e, B:14:0x0074, B:16:0x007a, B:18:0x0099, B:23:0x007e, B:24:0x0082, B:25:0x0087, B:27:0x008d, B:28:0x0091), top: B:3:0x0028, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r5, java.lang.String r7, java.lang.String r8, com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor r9, com.mobile.auth.gatewayauth.e r10) {
        /*
            r4 = this;
            r4.f37089x = r5     // Catch: java.lang.Throwable -> Lac
            r4.d()     // Catch: java.lang.Throwable -> Lac
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Throwable -> Lac
            android.content.Context r6 = r4.f37068c     // Catch: java.lang.Throwable -> Lac
            java.lang.Class<com.mobile.auth.gatewayauth.LoginAuthActivity> r0 = com.mobile.auth.gatewayauth.LoginAuthActivity.class
            r5.<init>(r6, r0)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "number"
            r5.putExtra(r6, r7)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "vendor"
            r5.putExtra(r6, r8)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "ui_manager_id"
            int r0 = r4.f37079n     // Catch: java.lang.Throwable -> Lac
            r5.putExtra(r6, r0)     // Catch: java.lang.Throwable -> Lac
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "startTime"
            r5.putExtra(r6, r0)     // Catch: java.lang.Throwable -> Lac
            r4.a(r9)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mobile.auth.gatewayauth.d> r6 = com.mobile.auth.gatewayauth.d.f37067b     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            int r9 = r4.f37079n     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            r6.put(r9, r4)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.ref.WeakReference<android.app.Activity> r6 = r4.f37070e     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            r9 = 0
            if (r6 == 0) goto L44
            java.lang.ref.WeakReference<android.app.Activity> r6 = r4.f37070e     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            android.app.Activity r6 = (android.app.Activity) r6     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L45
        L44:
            r6 = r9
        L45:
            com.mobile.auth.gatewayauth.AuthUIConfig r0 = r4.q()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.String r0 = r0.getAuthPageActIn()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = 1
            if (r0 == 0) goto L8b
            com.mobile.auth.gatewayauth.AuthUIConfig r0 = r4.q()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.String r0 = r0.getActivityOut()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            if (r0 == 0) goto L8b
            if (r6 == 0) goto L82
            com.mobile.auth.gatewayauth.AuthUIConfig r0 = r4.q()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.String r0 = r0.getAuthPageActIn()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            com.mobile.auth.gatewayauth.AuthUIConfig r1 = r4.q()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            java.lang.String r1 = r1.getActivityOut()     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            if (r3 != 0) goto L7e
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            if (r3 != 0) goto L7e
            com.nirvana.tools.core.SupportJarUtils.startActivityForResult(r6, r5, r2, r0, r1)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L97
        L7e:
            com.nirvana.tools.core.SupportJarUtils.startActivityForResult(r6, r5, r2, r9, r9)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L97
        L82:
            r5.addFlags(r1)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            android.content.Context r6 = r4.f37068c     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
        L87:
            r6.startActivity(r5)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L97
        L8b:
            if (r6 == 0) goto L91
            r6.startActivityForResult(r5, r2)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L97
        L91:
            r5.addFlags(r1)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            android.content.Context r6 = r4.f37068c     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto L87
        L97:
            if (r10 == 0) goto Lb0
            r10.a(r8, r7)     // Catch: java.lang.Exception -> L9d java.lang.Throwable -> Lac
            goto Lb0
        L9d:
            r5 = move-exception
            java.lang.String r5 = com.nirvana.tools.core.ExecutorManager.getErrorInfoFromException(r5)     // Catch: java.lang.Throwable -> Lac
            com.mobile.auth.gatewayauth.utils.i.c(r5)     // Catch: java.lang.Throwable -> Lac
            r10.a(r5)     // Catch: java.lang.Throwable -> Lac
            r4.A()     // Catch: java.lang.Throwable -> Lac
            goto Lb0
        Lac:
            r5 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r5)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.d.a(long, java.lang.String, java.lang.String, com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor, com.mobile.auth.gatewayauth.e):void");
    }

    public void a(Activity activity) {
        Intent intent;
        try {
            if ((activity instanceof LoginAuthActivity) && (intent = activity.getIntent()) != null && intent.getIntExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, -1) == this.f37079n) {
                this.f37081p = new WeakReference<>(activity);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(ActivityResultListener activityResultListener) {
        try {
            this.f37083r = activityResultListener;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(AuthRegisterXmlConfig authRegisterXmlConfig) {
        try {
            try {
                if (this.f37075j == null) {
                    this.f37075j = new ArrayList<>();
                }
                this.f37075j.add(authRegisterXmlConfig);
                a((Object) authRegisterXmlConfig);
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(AuthUIConfig authUIConfig) {
        try {
            this.f37072g = authUIConfig;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(AuthUIControlClickListener authUIControlClickListener) {
        try {
            this.f37069d = authUIControlClickListener;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(TokenResultListener tokenResultListener) {
        try {
            this.f37082q = tokenResultListener;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(ResultCodeProcessor resultCodeProcessor) {
        try {
            this.f37086u = resultCodeProcessor;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(Class<?> cls, int i10, int i11) {
        Activity activity;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            ((LoginAuthActivity) activity).openUserPage(cls, i10, i11);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(Object obj) {
        try {
            if (this.f37077l == null) {
                this.f37077l = new ArrayList<>();
            }
            this.f37077l.add(obj);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_ERROR_USER_CANCEL, this.f37068c, null);
            }
            c(str, this.f37085t.j(str), Constant.CODE_ERROR_USER_CANCEL);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(final String str, final long j10, final boolean z10, final boolean z11) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.d.8
                @Override // java.lang.Runnable
                public void run() {
                    ResultCodeProcessor i10;
                    String str2;
                    try {
                        com.mobile.auth.q.a d10 = d.d(d.this);
                        com.mobile.auth.gatewayauth.manager.d h10 = d.h(d.this);
                        String str3 = str;
                        String m10 = d.g(d.this).m(str);
                        UStruct.Builder endTime = UStruct.newUStruct().isSuccess(z11).isFullScreen(String.valueOf(!d.this.q().isDialog())).isVertical(String.valueOf(z10)).isChecked(String.valueOf(d.this.q().isCheckboxHidden() || d.this.q().isPrivacyState())).isCheckboxHidden(String.valueOf(d.this.q().isCheckboxHidden())).requestId(d.h(d.this).e()).sessionId(d.h(d.this).c()).startTime(j10).endTime(d.j(d.this));
                        if (z11) {
                            i10 = d.i(d.this);
                            str2 = Constant.CODE_START_AUTH_PAGE_SUCCESS;
                        } else {
                            i10 = d.i(d.this);
                            str2 = Constant.CODE_ERROR_START_AUTH_PAGE_FAIL;
                        }
                        d10.a(h10.b(str3, m10, endTime.authSdkCode(i10.convertCode(str2)).build(), ""), 1);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(String str, AuthRegisterViewConfig authRegisterViewConfig) {
        try {
            try {
                if (this.f37073h == null) {
                    this.f37073h = new LinkedHashMap<>();
                }
                this.f37073h.put(str, authRegisterViewConfig);
                if (authRegisterViewConfig.getRootViewId() == 0) {
                    a(authRegisterViewConfig);
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(String str, String str2) {
        Activity activity;
        Intent intent;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                this.f37080o.e("LoginAuthActivity实例被释放");
                return;
            }
            AuthUIConfig q10 = q();
            this.f37072g = q10;
            if (TextUtils.isEmpty(q10.getProtocolAction())) {
                intent = new Intent(activity, (Class<?>) AuthWebVeiwActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("name", str);
                intent.putExtra("orientation", q().getScreenOrientation());
                intent.putExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, this.f37079n);
            } else {
                intent = new Intent();
                intent.setAction(this.f37072g.getProtocolAction());
                if (!TextUtils.isEmpty(this.f37072g.getPackageName())) {
                    intent.setPackage(this.f37072g.getPackageName());
                }
                intent.putExtra("url", str2);
                intent.putExtra("name", str);
                intent.putExtra("orientation", q().getScreenOrientation());
            }
            activity.startActivity(intent);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(String str, String str2, String str3, boolean z10) {
        try {
            if (this.f37069d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", str2);
                    jSONObject.put("url", str3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f37069d.onClick(ResultCode.CODE_ERROR_USER_PROTOCOL_CONTROL, this.f37068c, jSONObject.toString());
            }
            if (z10) {
                a(str, this.f37085t.l(str), str3);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(String str, boolean z10, boolean z11) {
        try {
            if (this.f37069d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isChecked", z10);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f37069d.onClick(ResultCode.CODE_ERROR_USER_LOGIN_BTN, this.f37068c, jSONObject.toString());
            }
            a(str, this.f37085t.h(str), z10, z11);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(boolean z10) {
        try {
            this.f37091z = z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void a(boolean z10, String str, String str2) {
        try {
            a(z10, str, str2, true);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(Activity activity) {
        try {
            this.f37070e = new WeakReference<>(activity);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(AuthRegisterXmlConfig authRegisterXmlConfig) {
        try {
            try {
                if (this.f37076k == null) {
                    this.f37076k = new ArrayList<>();
                }
                this.f37076k.add(authRegisterXmlConfig);
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(ResultCodeProcessor resultCodeProcessor) {
        try {
            this.f37084s.a(this.f37089x, new TokenResultListener() { // from class: com.mobile.auth.gatewayauth.d.4
                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenFailed(String str) {
                    try {
                        if (d.f(d.this) != null) {
                            d.f(d.this).onTokenFailed(str);
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }

                @Override // com.mobile.auth.gatewayauth.TokenResultListener
                public void onTokenSuccess(String str) {
                    try {
                        if (d.f(d.this) != null) {
                            d.f(d.this).onTokenSuccess(str);
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            }, resultCodeProcessor);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(Object obj) {
        try {
            if (this.f37078m == null) {
                this.f37078m = new ArrayList<>();
            }
            this.f37078m.add(obj);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_ERROR_USER_CONTROL_CANCEL_BYBTN, this.f37068c, null);
            }
            c(str, this.f37085t.j(str), ResultCode.CODE_ERROR_USER_CONTROL_CANCEL_BYBTN);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(String str, AuthRegisterViewConfig authRegisterViewConfig) {
        try {
            try {
                if (this.f37074i == null) {
                    this.f37074i = new LinkedHashMap<>();
                }
                this.f37074i.put(str, authRegisterViewConfig);
                if (authRegisterViewConfig.getRootViewId() == 0) {
                    b(authRegisterViewConfig);
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(String str, String str2, String str3, boolean z10) {
        try {
            if (this.f37069d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", str3);
                    jSONObject.put("url", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f37069d.onClick(ResultCode.CODE_CLICK_AUTH_PRIVACY_WEBURL, this.f37068c, jSONObject.toString());
            }
            if (z10) {
                a(str, this.f37085t.k(str), ResultCode.CODE_CLICK_AUTH_PRIVACY_WEBURL, str2, str3);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(String str, boolean z10, boolean z11) {
        try {
            if (this.f37069d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isChecked", z10);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f37069d.onClick(ResultCode.CODE_START_AUTH_PRIVACY, this.f37068c, jSONObject.toString());
            }
            a(str, this.f37085t.i(str), z11);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void b(boolean z10) {
        try {
            this.A = z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public boolean b() {
        try {
            return this.E;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void c() {
        try {
            this.E = true;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void c(Activity activity) {
        try {
            this.f37071f = new WeakReference<>(activity);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void c(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_ERROR_USER_CONTROL_CANCEL_BYKEY, this.f37068c, null);
            }
            c(str, this.f37085t.j(str), ResultCode.CODE_ERROR_USER_CONTROL_CANCEL_BYKEY);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void c(boolean z10) {
        try {
            this.B = z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void d() {
        try {
            Application application = ReflectionUtils.getApplication();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(this.F);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void d(final Activity activity) {
        try {
            ExecutorManager.getInstance().postMain(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.d.7
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onException(Throwable th) {
                    try {
                        d.d(d.this).e("QuitActivity error!", ExecutorManager.getErrorInfoFromException(th));
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }

                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onFinal() {
                    try {
                        super.onFinal();
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }

                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void safeRun() {
                    try {
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            activity2.finish();
                            d.b(d.this, (WeakReference) null);
                            d dVar = d.this;
                            d.a(dVar, dVar.q());
                            if (d.e(d.this).getPrivacyAlertExitAnimation() == null || d.e(d.this).getPrivacyAlertEntryAnimation() == null) {
                                return;
                            }
                            Activity activity3 = activity;
                            activity3.overridePendingTransition(AppUtils.getAnimResID(activity3, d.e(d.this).getPrivacyAlertEntryAnimation()), AppUtils.getAnimResID(activity, d.e(d.this).getPrivacyAlertExitAnimation()));
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void d(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_ERROR_USER_SWITCH, this.f37068c, null);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void d(boolean z10) {
        try {
            this.D = z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void e(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_CLICK_AUTH_PRIVACY_CONFIRM, this.f37068c, null);
            }
            b(str, Constant.ACTION_CLICK_PRIVACYALERT_CONFIRM, ResultCode.CODE_CLICK_AUTH_PRIVACY_CONFIRM);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void e(boolean z10) {
        try {
            this.C = z10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public boolean e() {
        try {
            return this.f37091z;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void f(String str) {
        try {
            AuthUIControlClickListener authUIControlClickListener = this.f37069d;
            if (authUIControlClickListener != null) {
                authUIControlClickListener.onClick(ResultCode.CODE_AUTH_PRIVACY_CLOSE, this.f37068c, null);
            }
            b(str, Constant.ACTION_PRIVACYALERT_CLOSE, ResultCode.CODE_AUTH_PRIVACY_CLOSE);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void f(boolean z10) {
        Activity activity;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            ((LoginAuthActivity) activity).setProtocolChecked(z10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public boolean f() {
        try {
            return this.A;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void g(boolean z10) {
        try {
            if (this.f37069d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isChecked", z10);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f37069d.onClick(ResultCode.CODE_ERROR_USER_CHECKBOX, this.f37068c, jSONObject.toString());
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public boolean g() {
        try {
            return this.B;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean h() {
        try {
            return this.D;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public boolean i() {
        try {
            return this.C;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void j() {
        try {
            ExecutorManager.getInstance().postMain(new ExecutorManager.SafeRunnable() { // from class: com.mobile.auth.gatewayauth.d.5
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void onException(Throwable th) {
                    try {
                        d.d(d.this).e("Hide Loading error!", ExecutorManager.getErrorInfoFromException(th));
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.nirvana.tools.core.ExecutorManager.SafeRunnable
                public void safeRun() {
                    Activity activity;
                    try {
                        if (d.b(d.this) == null || (activity = (Activity) d.b(d.this).get()) == null) {
                            return;
                        }
                        ((LoginAuthActivity) activity).hideLoadingDialog();
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void k() {
        Activity activity;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            ((LoginAuthActivity) activity).animateProtocolTV();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void l() {
        Activity activity;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            ((LoginAuthActivity) activity).animateCheckBox();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public boolean m() {
        Activity activity;
        try {
            WeakReference<Activity> weakReference = this.f37081p;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return true;
            }
            return ((LoginAuthActivity) activity).queryCheckBoxIsChecked();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void n() {
        try {
            a(false, (String) null, (String) null, false);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public ActivityResultListener o() {
        try {
            return this.f37083r;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public void p() {
        try {
            if (this.f37082q != null) {
                TokenRet tokenRet = new TokenRet();
                tokenRet.setVendorName(this.f37085t.d());
                tokenRet.setCode(ResultCode.CODE_ERROR_LOAD_CUSTOM_VIEWS);
                tokenRet.setMsg(ResultCode.MSG_ERROR_LOAD_CUSTOM_VIEWS);
                this.f37082q.onTokenFailed(tokenRet.toJsonString());
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public AuthUIConfig q() {
        try {
            AuthUIConfig authUIConfig = this.f37072g;
            return authUIConfig == null ? f37066a : authUIConfig;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public LinkedHashMap<String, AuthRegisterViewConfig> r() {
        try {
            if (this.f37073h == null) {
                this.f37073h = new LinkedHashMap<>();
            }
            return this.f37073h;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public LinkedHashMap<String, AuthRegisterViewConfig> s() {
        try {
            if (this.f37074i == null) {
                this.f37074i = new LinkedHashMap<>();
            }
            return this.f37074i;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public ArrayList<AuthRegisterXmlConfig> t() {
        try {
            if (this.f37075j == null) {
                this.f37075j = new ArrayList<>();
            }
            return this.f37075j;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public ArrayList<AuthRegisterXmlConfig> u() {
        try {
            if (this.f37076k == null) {
                this.f37076k = new ArrayList<>();
            }
            return this.f37076k;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public void v() {
        try {
            try {
                LinkedHashMap<String, AuthRegisterViewConfig> linkedHashMap = this.f37073h;
                if (linkedHashMap != null) {
                    ArrayList<Object> arrayList = this.f37077l;
                    if (arrayList != null) {
                        arrayList.removeAll(linkedHashMap.values());
                    }
                    this.f37073h.clear();
                    this.f37073h = null;
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void w() {
        try {
            try {
                LinkedHashMap<String, AuthRegisterViewConfig> linkedHashMap = this.f37074i;
                if (linkedHashMap != null) {
                    ArrayList<Object> arrayList = this.f37078m;
                    if (arrayList != null) {
                        arrayList.removeAll(linkedHashMap.values());
                    }
                    this.f37074i.clear();
                    this.f37074i = null;
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void x() {
        try {
            try {
                ArrayList<AuthRegisterXmlConfig> arrayList = this.f37076k;
                if (arrayList != null) {
                    arrayList.clear();
                    this.f37076k = null;
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void y() {
        try {
            try {
                ArrayList<AuthRegisterXmlConfig> arrayList = this.f37075j;
                if (arrayList != null) {
                    ArrayList<Object> arrayList2 = this.f37077l;
                    if (arrayList2 != null) {
                        arrayList2.removeAll(arrayList);
                    }
                    this.f37075j.clear();
                    this.f37075j = null;
                }
            } catch (Exception e2) {
                i.a(e2);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void z() {
        try {
            if (this.f37071f == null || this.f37071f.get() == null || !(this.f37071f.get() instanceof PrivacyDialogActivity)) {
                return;
            }
            ((PrivacyDialogActivity) this.f37071f.get()).cancelPrivacyDialog();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }
}
