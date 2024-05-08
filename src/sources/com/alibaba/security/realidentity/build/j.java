package com.alibaba.security.realidentity.build;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;
import com.alibaba.security.realidentity.ErrorCode;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.activity.RpLoadingActivity;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import com.alibaba.security.realidentity.http.RPHttpManager;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.HashMap;

/* compiled from: RPVerifyManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class j implements gy {

    /* renamed from: u, reason: collision with root package name */
    private static final String f3890u = "RPVerifyManager";

    /* renamed from: a, reason: collision with root package name */
    public final an f3891a;

    /* renamed from: b, reason: collision with root package name */
    public final RPSkinManager f3892b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f3893c;

    /* renamed from: d, reason: collision with root package name */
    public Context f3894d;

    /* renamed from: e, reason: collision with root package name */
    public String f3895e;

    /* renamed from: f, reason: collision with root package name */
    public RPEnv f3896f;

    /* renamed from: g, reason: collision with root package name */
    public String f3897g;

    /* renamed from: h, reason: collision with root package name */
    public RPConfig f3898h;

    /* renamed from: i, reason: collision with root package name */
    public b f3899i;

    /* renamed from: j, reason: collision with root package name */
    public ho f3900j;

    /* renamed from: k, reason: collision with root package name */
    public gx f3901k;

    /* renamed from: l, reason: collision with root package name */
    public final RPHttpManager f3902l;

    /* renamed from: m, reason: collision with root package name */
    public final SensorGetter f3903m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f3904n;

    /* renamed from: o, reason: collision with root package name */
    public long f3905o;

    /* renamed from: p, reason: collision with root package name */
    public String f3906p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3907q;

    /* renamed from: r, reason: collision with root package name */
    public CtidConfig f3908r;

    /* renamed from: s, reason: collision with root package name */
    public p f3909s;

    /* renamed from: t, reason: collision with root package name */
    public o f3910t;

    /* renamed from: v, reason: collision with root package name */
    private aa f3911v;

    /* compiled from: RPVerifyManager.java */
    /* renamed from: com.alibaba.security.realidentity.build.j$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3912a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3913b;

        public AnonymousClass1(Context context, String str) {
            this.f3912a = context;
            this.f3913b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            Context context = this.f3912a;
            String str = this.f3913b;
            jVar.a(context, j.a(j.a(jVar.f3897g, "token", str), "fromSource", com.alibaba.security.realidentity.build.a.f2995a), str);
        }
    }

    /* compiled from: RPVerifyManager.java */
    /* renamed from: com.alibaba.security.realidentity.build.j$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3915a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3916b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3917c;

        public AnonymousClass2(Context context, String str, String str2) {
            this.f3915a = context;
            this.f3916b = str;
            this.f3917c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.a(this.f3915a, this.f3916b, this.f3917c);
        }
    }

    /* compiled from: RPVerifyManager.java */
    /* renamed from: com.alibaba.security.realidentity.build.j$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3919a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3920b;

        public AnonymousClass3(Context context, String str) {
            this.f3919a = context;
            this.f3920b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            jVar.a(this.f3919a, this.f3920b, jVar.f3899i);
        }
    }

    /* compiled from: RPVerifyManager.java */
    /* renamed from: com.alibaba.security.realidentity.build.j$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RPEventListener f3922a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f3923b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3924c;

        private AnonymousClass4(RPEventListener rPEventListener, Activity activity, String str) {
            this.f3922a = rPEventListener;
            this.f3923b = activity;
            this.f3924c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            if (jVar.f3908r == null) {
                jVar.f3904n = false;
                RPResult rPResult = RPResult.AUDIT_FAIL;
                this.f3922a.onFinish(rPResult, new ErrorCode(j.a(rPResult, "-10415"), "-10415", "CTID auth failed"));
                return;
            }
            final hi hiVar = new hi();
            new Runnable() { // from class: com.alibaba.security.realidentity.build.j.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.f3904n = false;
                    AnonymousClass4.this.f3922a.onFinish(RPResult.AUDIT_NOT, new ErrorCode(j.a(RPResult.AUDIT_FAIL, "-10415"), "-10415", "CTID auth failed by user exit"));
                }
            };
        }
    }

    /* compiled from: RPVerifyManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final j f3944a = new j(0);

        private a() {
        }
    }

    public /* synthetic */ j(byte b4) {
        this();
    }

    private RPEnv A() {
        return this.f3896f;
    }

    private String B() {
        return this.f3906p;
    }

    private static byte[] a(byte[] bArr) {
        return bArr;
    }

    private static /* synthetic */ boolean d(j jVar) {
        jVar.f3904n = false;
        return false;
    }

    private Pair<Boolean, String> i() {
        return this.f3901k.b();
    }

    private Pair<Boolean, String> j() {
        return this.f3901k.l();
    }

    private Pair<Boolean, String> k() {
        gx gxVar = this.f3901k;
        if (gxVar == null) {
            return null;
        }
        return gxVar.b();
    }

    private Context l() {
        return this.f3894d;
    }

    @Deprecated
    private static void m() {
    }

    @Deprecated
    private String n() {
        return this.f3895e;
    }

    private RPEnv o() {
        return this.f3896f;
    }

    private RPEventListener p() {
        return this.f3899i;
    }

    private void q() {
        this.f3899i = null;
    }

    private boolean r() {
        return this.f3904n;
    }

    private static void s() {
        RPTrack.uploadNow();
    }

    private String t() {
        return this.f3901k.d();
    }

    private String u() {
        return this.f3901k.f();
    }

    private String v() {
        return this.f3901k.g();
    }

    private String w() {
        return this.f3901k.h();
    }

    private String x() {
        return this.f3901k.i();
    }

    private String y() {
        return this.f3901k.j();
    }

    private static String z() {
        return VersionKey.RP_SDK_VERSION;
    }

    @Override // com.alibaba.security.realidentity.build.gy
    public final void collectLog(TrackLog trackLog) {
        a(trackLog);
    }

    private j() {
        this.f3894d = null;
        this.f3895e = "";
        this.f3896f = RPEnv.ONLINE;
        this.f3897g = "https://market.m.taobao.com/app/msd/m-rp-h5/cloud.html";
        this.f3898h = null;
        this.f3899i = null;
        this.f3907q = true;
        this.f3900j = new ho();
        this.f3901k = new gx(this);
        this.f3904n = false;
        this.f3891a = new an();
        this.f3893c = new Handler(Looper.getMainLooper());
        this.f3902l = new RPHttpManager();
        this.f3892b = RPSkinManager.getInstance();
        this.f3903m = SensorGetter.getDefault();
    }

    private boolean a(Context context) {
        RPEnv rPEnv = this.f3896f;
        this.f3894d = context.getApplicationContext();
        this.f3896f = rPEnv;
        l a10 = l.a.a();
        a10.f3947a = new k();
        a10.b();
        this.f3902l.init(this.f3901k, this.f3896f);
        this.f3902l.setTrackLog(this);
        this.f3901k.a(this.f3894d);
        RPTrack.init(this.f3894d);
        an anVar = this.f3891a;
        anVar.f3086b = new ao(anVar.f3085a, context);
        RPTrack.setUploadImpl(new gz(this.f3894d));
        this.f3903m.init(context);
        return ho.a(this.f3894d);
    }

    private void c(Context context, String str, RPEventListener rPEventListener) {
        an anVar = this.f3891a;
        if (anVar != null) {
            anVar.a();
        }
        String a10 = a(str);
        a(a10, a(), "url");
        this.f3899i = a(rPEventListener);
        if (b(a10)) {
            this.f3906p = "url";
            this.f3895e = a10;
            this.f3905o = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(this.f3901k.j());
            a(context, a10, this.f3899i, new AnonymousClass2(context, a(str, "fromSource", com.alibaba.security.realidentity.build.a.f2995a), a10), this.f3901k);
        }
    }

    private void d(Context context, String str, RPEventListener rPEventListener) {
        an anVar = this.f3891a;
        if (anVar != null) {
            anVar.a();
        }
        a(str, a(), AgdManager.SOURCE_NATIVE);
        a(context, str);
        this.f3899i = a(rPEventListener);
        if (b(str)) {
            this.f3906p = AgdManager.SOURCE_NATIVE;
            this.f3895e = str;
            this.f3905o = System.currentTimeMillis();
            RPLogging.d(f3890u, "startVerifyByNative token is: ".concat(String.valueOf(str)));
            this.f3899i.onStart();
            GetCacheDataManager.getInstance().setUmidToken(this.f3901k.j());
            a(context, str, this.f3899i, new AnonymousClass3(context, str), this.f3901k);
        }
    }

    private String e(String str) {
        return this.f3901k.a(str);
    }

    private static j f() {
        return a.f3944a;
    }

    private boolean g() {
        return ho.a(this.f3894d);
    }

    private void h() {
        Thread.setDefaultUncaughtExceptionHandler(this.f3891a.f3085a);
    }

    private void b(Context context, String str, RPEventListener rPEventListener) {
        an anVar = this.f3891a;
        if (anVar != null) {
            anVar.a();
        }
        a(str, a(), TrackConstants.Layer.H5);
        a(context, str);
        this.f3899i = a(rPEventListener);
        if (b(str)) {
            this.f3906p = TrackConstants.Layer.H5;
            this.f3895e = str;
            this.f3905o = System.currentTimeMillis();
            RPLogging.d(f3890u, "startVerify token is: ".concat(String.valueOf(str)));
            GetCacheDataManager.getInstance().setUmidToken(this.f3901k.j());
            a(context, str, this.f3899i, new AnonymousClass1(context, str), this.f3901k);
        }
    }

    private String f(String str) {
        return this.f3901k.b(str);
    }

    private void g(String str) {
        this.f3906p = str;
    }

    public final boolean e() {
        return this.f3907q && CommonUtils.checkWindVaneExist();
    }

    private void c(String str) {
        this.f3895e = str;
    }

    private void b(Context context, String str) {
        a(context, a(a(this.f3897g, "token", str), "fromSource", com.alibaba.security.realidentity.build.a.f2995a), str);
    }

    private void d(String str) {
        this.f3897g = str;
    }

    public final RPConfig c() {
        if (this.f3898h == null) {
            this.f3898h = new RPConfig.Builder().build();
        }
        return this.f3898h;
    }

    private boolean a(Context context, RPEnv rPEnv) {
        this.f3894d = context.getApplicationContext();
        this.f3896f = rPEnv;
        l a10 = l.a.a();
        a10.f3947a = new k();
        a10.b();
        this.f3902l.init(this.f3901k, this.f3896f);
        this.f3902l.setTrackLog(this);
        this.f3901k.a(this.f3894d);
        RPTrack.init(this.f3894d);
        an anVar = this.f3891a;
        anVar.f3086b = new ao(anVar.f3085a, context);
        RPTrack.setUploadImpl(new gz(this.f3894d));
        this.f3903m.init(context);
        return ho.a(this.f3894d);
    }

    public final Pair<Boolean, String> d() {
        RPTrack.setLastStepTrackMsg(null);
        Pair<Boolean, String> k10 = k();
        GetCacheDataManager.getInstance().setUmidToken(this.f3901k.j());
        return k10;
    }

    private static void b(RPEventListener rPEventListener) {
        if (rPEventListener != null) {
            RPResult rPResult = RPResult.AUDIT_FAIL;
            rPEventListener.onFinish(rPResult, new ErrorCode(a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST"));
        }
    }

    public final void b() {
        if (this.f3911v != null) {
            collectLog(TrackLog.createDynamicInterruptLog());
            this.f3911v.f3006f = true;
            this.f3911v = null;
        }
        if (this.f3910t != null) {
            collectLog(TrackLog.createStartInterruptLog());
            this.f3910t.a();
        }
    }

    public final boolean b(String str) {
        Pair<Boolean, String> l10 = this.f3901k.l();
        if (!((Boolean) l10.first).booleanValue()) {
            this.f3899i.b(RPResult.AUDIT_NOT, "-10403", (String) l10.second, str);
            return false;
        }
        Pair<Boolean, String> d10 = d();
        if (!((Boolean) d10.first).booleanValue()) {
            this.f3899i.b(RPResult.AUDIT_NOT, "-10403", (String) d10.second, str);
            return false;
        }
        if (this.f3904n) {
            this.f3899i.a(RPResult.AUDIT_NOT, "-10404", "重复认证，上一次认证还未结束", str);
            return false;
        }
        this.f3904n = true;
        return true;
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str4 = SymbolValues.QUESTION_EN_SYMBOL;
        if (str.lastIndexOf(SymbolValues.QUESTION_EN_SYMBOL) >= 0) {
            str4 = "&";
        }
        sb2.append(str4);
        sb2.append(str2);
        sb2.append("=");
        sb2.append(str3);
        String sb3 = sb2.toString();
        RPLogging.d(f3890u, "originalUrl:" + str + "\nnewUrl:" + sb3);
        return sb3;
    }

    public final boolean a() {
        ALBiometricsConfig biometricsConfig = c().getBiometricsConfig();
        if (biometricsConfig == null) {
            return false;
        }
        boolean isSkinInAssets = biometricsConfig.isSkinInAssets();
        String skinPath = biometricsConfig.getSkinPath();
        if (!isSkinInAssets && TextUtils.isEmpty(skinPath)) {
            return false;
        }
        this.f3892b.init(this.f3894d, skinPath, isSkinInAssets);
        return true;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str.substring(str.indexOf(SymbolValues.QUESTION_EN_SYMBOL) + 1).split("&");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            return (String) hashMap.get("token");
        } catch (Exception e2) {
            RPLogging.e(f3890u, e2);
            return "";
        }
    }

    private void a(CtidConfig ctidConfig) {
        this.f3908r = ctidConfig;
    }

    public final void a(Context context, String str, RPEventListener rPEventListener) {
        o oVar = new o(context, str, rPEventListener);
        this.f3910t = oVar;
        oVar.a(null);
    }

    public final void a(Context context, String str, String str2) {
        this.f3905o = System.currentTimeMillis();
        Intent intent = new Intent();
        if (RPLogging.isEnable()) {
            RPLogging.d(f3890u, "processStartVerifyWithUrl: ".concat(String.valueOf(str)));
        }
        intent.putExtra("url", str);
        intent.putExtra("token", str2);
        intent.setFlags(268435456);
        intent.setClass(context, RPWebViewActivity.class);
        context.startActivity(intent);
    }

    private void a(RPEnv rPEnv) {
        this.f3896f = rPEnv;
        gx gxVar = this.f3901k;
        gxVar.f3784a = rPEnv;
        gxVar.f3786d = null;
        gxVar.f3787e = null;
        this.f3902l.updateEnv(rPEnv);
    }

    private void a(RPConfig rPConfig) {
        this.f3898h = rPConfig;
    }

    public final b a(final RPEventListener rPEventListener) {
        return new b() { // from class: com.alibaba.security.realidentity.build.j.5
            private void c(final RPResult rPResult, final String str, final String str2, String str3) {
                final String a10 = j.a(rPResult, str);
                j.this.a(rPResult, str, str2, str3);
                j.this.f3901k.c();
                RPTrack.release();
                j.this.f3892b.release();
                j.a(j.this);
                LocalBroadcastManagerUtils.dismiss();
                p pVar = j.this.f3909s;
                if (pVar != null) {
                    pVar.b();
                }
                j.this.f3893c.post(new Runnable() { // from class: com.alibaba.security.realidentity.build.j.5.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.f3904n = false;
                        rPEventListener.onFinish(rPResult, new ErrorCode(a10, str, str2));
                        a.f3944a.f3899i = null;
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.build.b
            public final void a(final RPResult rPResult, final String str, final String str2, String str3) {
                final String a10 = j.a(rPResult, str);
                j.this.a(rPResult, str, str2, str3);
                j.this.f3893c.post(new Runnable() { // from class: com.alibaba.security.realidentity.build.j.5.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar = j.this.f3909s;
                        if (pVar != null) {
                            pVar.b();
                        }
                        rPEventListener.onFinish(rPResult, new ErrorCode(a10, str, str2));
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.build.b
            public final void b(RPResult rPResult, String str, String str2, String str3) {
                c(rPResult, str, str2, str3);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsFinish(final int i10) {
                j.this.f3893c.post(new Runnable() { // from class: com.alibaba.security.realidentity.build.j.5.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.f3904n = false;
                        rPEventListener.onBiometricsFinish(i10);
                        RPTrack.uploadNow();
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsStart() {
                j.this.f3893c.post(new Runnable() { // from class: com.alibaba.security.realidentity.build.j.5.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        rPEventListener.onBiometricsStart();
                        p pVar = j.this.f3909s;
                        if (pVar != null) {
                            pVar.b();
                        }
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str, String str2) {
                c(rPResult, str, str2, j.this.f3895e);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onStart() {
                super.onStart();
                j.this.f3893c.post(new Runnable() { // from class: com.alibaba.security.realidentity.build.j.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        rPEventListener.onStart();
                        p pVar = j.this.f3909s;
                        if (pVar != null) {
                            pVar.b();
                        }
                    }
                });
            }
        };
    }

    public static String a(RPResult rPResult, String str) {
        if (rPResult == RPResult.AUDIT_PASS) {
            return "1";
        }
        try {
            return GlobalErrorCode.mappingResultCode(Integer.decode(str).intValue());
        } catch (Exception unused) {
            return "-10000";
        }
    }

    public static void a(String str, TrackLog trackLog) {
        trackLog.setVerifyToken(str);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        RPTrack.t(trackLog);
    }

    public final void a(String str, boolean z10, String str2) {
        a(str, TrackLog.createStartBeginLog(str2, c().getFromSource(), z10));
    }

    public final void a(RPResult rPResult, String str, String str2, String str3) {
        a(str3, TrackLog.createStartEndLog(this.f3906p, str2, this.f3905o, String.valueOf(rPResult.code), str));
        RPTrack.uploadNow();
    }

    private void a(ho hoVar) {
        this.f3900j = hoVar;
    }

    private void a(gx gxVar) {
        this.f3901k = gxVar;
    }

    private void a(boolean z10) {
        this.f3907q = z10;
    }

    public final void a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, gx gxVar) {
        aa aaVar = new aa(context, str, rPEventListener, runnable, gxVar);
        this.f3911v = aaVar;
        aaVar.execute(aa.f3004g);
    }

    private void a(p pVar) {
        this.f3909s = pVar;
    }

    private void a(long j10) {
        this.f3905o = j10;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) RpLoadingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(RpLoadingActivity.f2988a, str);
        context.startActivity(intent);
    }

    private void a(o oVar) {
        this.f3910t = oVar;
    }

    @Deprecated
    public final void a(TrackLog trackLog) {
        a(this.f3895e, trackLog);
    }

    public static /* synthetic */ void a(j jVar) {
        Thread.setDefaultUncaughtExceptionHandler(jVar.f3891a.f3085a);
    }
}
