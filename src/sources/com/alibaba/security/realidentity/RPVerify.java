package com.alibaba.security.realidentity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.build.an;
import com.alibaba.security.realidentity.build.ao;
import com.alibaba.security.realidentity.build.gx;
import com.alibaba.security.realidentity.build.gz;
import com.alibaba.security.realidentity.build.ho;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.k;
import com.alibaba.security.realidentity.build.l;
import com.huawei.appgallery.agd.base.api.AgdManager;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPVerify {
    private static final String DEMO_PACKAGE_NAME = "com.alibaba.security.realidentity.rpsdktest";
    private static final String curWebUrl = "https://market.m.taobao.com/app/msd/m-rp-h5/cloud.html";
    private static boolean isInit;

    private RPVerify() {
    }

    private static void a(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener, Runnable runnable) {
        Objects.requireNonNull(rPEventListener, "RPVerify#start rpEventListener is null");
        if (!isInit) {
            init(context);
        }
        if (context == null) {
            j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10401", "context is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10401", "verifyToken is null");
        } else {
            if (!isInit) {
                j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10400", "sdk init fail");
                return;
            }
            j.a.f3944a.f3898h = rPConfig;
            j.a.f3944a.f3897g = curWebUrl;
            runnable.run();
        }
    }

    public static boolean init(@NonNull Context context) {
        return init(context, false);
    }

    public static void setEnv(Context context, RPEnv rPEnv) {
        if (context.getPackageName().equals(DEMO_PACKAGE_NAME)) {
            j jVar = j.a.f3944a;
            jVar.f3896f = rPEnv;
            gx gxVar = jVar.f3901k;
            gxVar.f3784a = rPEnv;
            gxVar.f3786d = null;
            gxVar.f3787e = null;
            jVar.f3902l.updateEnv(rPEnv);
            return;
        }
        throw new RuntimeException("you do not allow to call this method");
    }

    public static void start(@NonNull Context context, String str, @NonNull RPEventListener rPEventListener) {
        start(context, str, null, rPEventListener);
    }

    public static void startByNative(Context context, String str, RPEventListener rPEventListener) {
        startByNative(context, str, null, rPEventListener);
    }

    public static void startWithUrl(Context context, String str, RPEventListener rPEventListener) {
        startWithUrl(context, str, null, rPEventListener);
    }

    public static String version() {
        j unused = j.a.f3944a;
        return VersionKey.RP_SDK_VERSION;
    }

    @Deprecated
    public static boolean init(@NonNull Context context, boolean z10) {
        if (isInit) {
            return true;
        }
        j jVar = j.a.f3944a;
        RPEnv rPEnv = jVar.f3896f;
        jVar.f3894d = context.getApplicationContext();
        jVar.f3896f = rPEnv;
        l lVar = l.a.f3948a;
        lVar.f3947a = new k();
        lVar.b();
        jVar.f3902l.init(jVar.f3901k, jVar.f3896f);
        jVar.f3902l.setTrackLog(jVar);
        jVar.f3901k.a(jVar.f3894d);
        RPTrack.init(jVar.f3894d);
        an anVar = jVar.f3891a;
        anVar.f3086b = new ao(anVar.f3085a, context);
        RPTrack.setUploadImpl(new gz(jVar.f3894d));
        jVar.f3903m.init(context);
        if (!ho.a(jVar.f3894d)) {
            isInit = false;
            return false;
        }
        isInit = true;
        return true;
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, @NonNull final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.1
            @Override // java.lang.Runnable
            public final void run() {
                j jVar = j.a.f3944a;
                Context context2 = context;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                an anVar = jVar.f3891a;
                if (anVar != null) {
                    anVar.a();
                }
                jVar.a(str2, jVar.a(), TrackConstants.Layer.H5);
                j.a(context2, str2);
                jVar.f3899i = jVar.a(rPEventListener2);
                if (jVar.b(str2)) {
                    jVar.f3906p = TrackConstants.Layer.H5;
                    jVar.f3895e = str2;
                    jVar.f3905o = System.currentTimeMillis();
                    RPLogging.d("RPVerifyManager", "startVerify token is: ".concat(String.valueOf(str2)));
                    GetCacheDataManager.getInstance().setUmidToken(jVar.f3901k.j());
                    jVar.a(context2, str2, jVar.f3899i, new j.AnonymousClass1(context2, str2), jVar.f3901k);
                }
            }
        });
    }

    public static void startByNative(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() { // from class: com.alibaba.security.realidentity.RPVerify.2
            @Override // java.lang.Runnable
            public final void run() {
                j jVar = j.a.f3944a;
                Context context2 = context;
                String str2 = str;
                RPEventListener rPEventListener2 = rPEventListener;
                an anVar = jVar.f3891a;
                if (anVar != null) {
                    anVar.a();
                }
                jVar.a(str2, jVar.a(), AgdManager.SOURCE_NATIVE);
                j.a(context2, str2);
                jVar.f3899i = jVar.a(rPEventListener2);
                if (jVar.b(str2)) {
                    jVar.f3906p = AgdManager.SOURCE_NATIVE;
                    jVar.f3895e = str2;
                    jVar.f3905o = System.currentTimeMillis();
                    RPLogging.d("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str2)));
                    jVar.f3899i.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(jVar.f3901k.j());
                    jVar.a(context2, str2, jVar.f3899i, new j.AnonymousClass3(context2, str2), jVar.f3901k);
                }
            }
        });
    }

    public static void startWithUrl(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener) {
        Objects.requireNonNull(rPEventListener, "RPVerify#start rpEventListener is null");
        if (!isInit) {
            init(context);
        }
        if (context == null) {
            j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10401", "context is empty");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10402", "url is empty");
            return;
        }
        if (!isInit) {
            j.a.f3944a.a(rPEventListener).onFinish(RPResult.AUDIT_NOT, "-10400", "sdk init fail");
            return;
        }
        j.a.f3944a.f3898h = rPConfig;
        j jVar = j.a.f3944a;
        an anVar = jVar.f3891a;
        if (anVar != null) {
            anVar.a();
        }
        String a10 = j.a(str);
        jVar.a(a10, jVar.a(), "url");
        jVar.f3899i = jVar.a(rPEventListener);
        if (jVar.b(a10)) {
            jVar.f3906p = "url";
            jVar.f3895e = a10;
            jVar.f3905o = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(jVar.f3901k.j());
            jVar.a(context, a10, jVar.f3899i, new j.AnonymousClass2(context, j.a(str, "fromSource", a.f2995a), a10), jVar.f3901k);
        }
    }
}
