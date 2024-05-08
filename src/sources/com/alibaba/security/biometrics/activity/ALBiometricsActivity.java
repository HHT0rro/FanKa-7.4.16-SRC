package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsRuntime;
import com.alibaba.security.biometrics.build.l;
import com.alibaba.security.biometrics.build.p;
import com.alibaba.security.biometrics.build.s;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.manager.ALBiometricsManager;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.DisplayUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.tools.flexible.Flexible;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsActivity extends BaseBioNavigatorActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2142a = "ALBiometricsActivity";

    /* renamed from: b, reason: collision with root package name */
    public static final String f2143b = "KEY_LAST_PID";

    /* renamed from: v, reason: collision with root package name */
    private ALBiometricsParams f2144v;

    /* renamed from: w, reason: collision with root package name */
    private ALBiometricsEventListener f2145w;

    /* renamed from: x, reason: collision with root package name */
    private ALBiometricsConfig f2146x;

    public static void a(Context context, ALBiometricsManager aLBiometricsManager) {
        Intent intent = new Intent(context, (Class<?>) ALBiometricsActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(ALBiometricsKeys.KEY_FACE_PARAMS, aLBiometricsManager.getParams());
        ALBiometricsConfig alBiometricsConfig = aLBiometricsManager.getAlBiometricsConfig();
        if (alBiometricsConfig != null) {
            BaseBioNavigatorActivity.f2188u = aLBiometricsManager.getAlBiometricsConfig().getTransitionMode();
        } else {
            BaseBioNavigatorActivity.f2188u = TransitionMode.NULL;
        }
        intent.putExtra(ALBiometricsKeys.KEY_BIO_CONFIG, alBiometricsConfig);
        intent.putExtra(ALBiometricsKeys.KEY_BIO_PARAMS_BUNDLE, aLBiometricsManager.getParamsBundle());
        ALBiometricsRuntime.mALBiometricsEventListener = new WeakReference<>(aLBiometricsManager.getEventListener());
        context.startActivity(intent);
        if (context instanceof Activity) {
            BaseBioNavigatorActivity.a((Activity) context, BaseBioNavigatorActivity.f2188u);
        }
    }

    private void b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", str);
        hashMap.put(ExposeManager.UtArgsNames.pid, String.valueOf(Process.myPid()));
        a(TrackLog.createBioActivityEnterLog(JsonUtils.toJSON(hashMap), str2));
    }

    private void c(String str, String str2) {
        a(TrackLog.createStartEndLog(str, str2, System.currentTimeMillis(), "-1", "-10414"));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RPLogging.d(f2142a, configuration.orientation == 1 ? "竖屏" : "横屏");
        RPLogging.d(f2142a, "width:" + DisplayUtils.dip2px(this, configuration.screenWidthDp) + "\nheight:" + DisplayUtils.dip2px(this, configuration.screenHeightDp));
        if (GetCacheDataManager.getInstance().getUseHwMagicWindow() && configuration.orientation == 1 && DisplayUtils.isInHuaweiMagicWindow(this)) {
            ((p) l.a(p.class)).a(GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW, "EnvironmentComponent", null);
        }
    }

    @Override // com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity, com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RPLogging.d(f2142a, "bio activity enter:" + b());
        WeakReference<ALBiometricsEventListener> weakReference = ALBiometricsRuntime.mALBiometricsEventListener;
        this.f2145w = weakReference != null ? weakReference.get() : null;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(ALBiometricsKeys.KEY_FACE_PARAMS)) {
            this.f2144v = (ALBiometricsParams) intent.getSerializableExtra(ALBiometricsKeys.KEY_FACE_PARAMS);
        }
        if (this.f2144v == null) {
            this.f2144v = new ALBiometricsParams();
        }
        String b4 = b();
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", b4);
        hashMap.put(ExposeManager.UtArgsNames.pid, String.valueOf(Process.myPid()));
        a(TrackLog.createBioActivityEnterLog(JsonUtils.toJSON(hashMap), "bio activity enter"));
        ALBiometricsEventListener aLBiometricsEventListener = this.f2145w;
        if (aLBiometricsEventListener == null) {
            a(ALBiometricsRuntime.mALBiometricsEventListener != null ? "ALBiometricsRuntime.mALBiometricsEventListener.get() is null " : "ALBiometricsRuntime.mALBiometricsEventListener is null", a(bundle) ? "The process to restart" : "");
            a(TrackLog.createStartEndLog(this.f2144v.mVerifyType, a(bundle) ? "true" : "false", System.currentTimeMillis(), "-1", "-10414"));
            finish();
            return;
        }
        aLBiometricsEventListener.onBiometricsStart();
        this.f2146x = (ALBiometricsConfig) intent.getSerializableExtra(ALBiometricsKeys.KEY_BIO_CONFIG);
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.initialToken(this.f2144v.secToken);
            ALBiometricsJni.bhL(1, "");
        } else {
            a("ALBiometricsJni load fail", (String) null);
        }
        l.a(this, this.f2144v, this.f2146x, this.f2145w);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = new ALBiometricsActivityParentView(this, this.f2144v);
        Flexible.setContentView(this, aLBiometricsActivityParentView);
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT > 28) {
            try {
                View decorView = window.getDecorView();
                decorView.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(decorView, Boolean.FALSE);
            } catch (Throwable unused) {
            }
        }
        ((p) l.a(p.class)).a(aLBiometricsActivityParentView);
        RPTrack.setLastStepTrackMsg(null);
    }

    @Override // com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity, com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RPLogging.d(f2142a, "bio activity exit");
        a(TrackLog.createBioActivityExitLog("bio activity exit"));
        l.c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (l.a(i10, keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        l.b();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        try {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        } catch (Throwable unused) {
        }
        s sVar = ((p) l.a(p.class)).f2318d;
        if (sVar == null || i10 != 1010) {
            return;
        }
        if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
            s.f();
        } else {
            sVar.b(false);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        l.a();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f2143b, Process.myPid());
    }

    private static boolean a(Bundle bundle) {
        return (bundle == null || bundle.getInt(f2143b, 0) == Process.myPid()) ? false : true;
    }

    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity
    public final boolean a() {
        ALBiometricsParams aLBiometricsParams = this.f2144v;
        return aLBiometricsParams != null && aLBiometricsParams.stepResult;
    }

    private void a(String str, String str2) {
        a(TrackLog.createSdkExceptionLog(str, str2, f2142a));
    }

    private void a(String str) {
        a(TrackLog.createBioActivityExitLog(str));
    }

    private void a(TrackLog trackLog) {
        ALBiometricsParams aLBiometricsParams = this.f2144v;
        if (aLBiometricsParams != null) {
            trackLog.setVerifyToken(aLBiometricsParams.mVerifyToken);
        }
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        RPTrack.t(trackLog);
        RPTrack.uploadNow();
    }
}
