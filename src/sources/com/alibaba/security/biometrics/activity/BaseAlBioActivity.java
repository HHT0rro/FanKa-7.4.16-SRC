package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.alibaba.security.biometrics.build.l;
import com.alibaba.security.biometrics.build.p;
import com.alibaba.security.biometrics.build.s;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseAlBioActivity extends Activity {

    /* renamed from: c, reason: collision with root package name */
    public static final String f2163c = "BaseBroadcastsActivity";

    /* renamed from: d, reason: collision with root package name */
    public RestartBiometricsBroadcast f2164d;

    /* renamed from: e, reason: collision with root package name */
    public FinishBiometricsBroadcast f2165e;

    /* renamed from: f, reason: collision with root package name */
    public a f2166f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class FinishBiometricsBroadcast extends BroadcastReceiver {
        public FinishBiometricsBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseAlBioActivity.this.finish();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RestartBiometricsBroadcast extends BroadcastReceiver {
        public RestartBiometricsBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final int i10 = 0;
            if (intent != null && TextUtils.equals(intent.getAction(), ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS)) {
                Bundle bundleExtra = intent.getBundleExtra("data");
                final String str = null;
                if (bundleExtra != null) {
                    i10 = bundleExtra.getInt(ALBiometricsKeys.KEY_ERROR_DETECT_K, GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
                    str = bundleExtra.getString(ALBiometricsKeys.KEY_ERROR_DETECT_MSG_K, null);
                }
                if (BaseAlBioActivity.this.a()) {
                    BaseAlBioActivity.this.f2166f.post(new Runnable() { // from class: com.alibaba.security.biometrics.activity.BaseAlBioActivity.RestartBiometricsBroadcast.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((p) l.a(p.class)).a(i10, "RestartBiometricsBroadcast", str);
                            s sVar = ((p) l.a(p.class)).f2318d;
                            if (sVar != null) {
                                sVar.f2333c = 0;
                            }
                        }
                    });
                } else {
                    BaseAlBioActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final BaseAlBioActivity f2172a;

        public a(BaseAlBioActivity baseAlBioActivity) {
            super(Looper.getMainLooper());
            this.f2172a = baseAlBioActivity;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }
    }

    private void c() {
        if (this.f2164d == null) {
            this.f2164d = new RestartBiometricsBroadcast();
            LocalBroadcastManagerUtils.getInstance(this).registerReceiver(this.f2164d, new IntentFilter(ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS));
        }
        if (this.f2165e == null) {
            this.f2165e = new FinishBiometricsBroadcast();
            LocalBroadcastManagerUtils.getInstance(this).registerReceiver(this.f2165e, new IntentFilter(ALBiometricsKeys.KEY_ACTION_FINISH_BIOMETRICS));
        }
    }

    private void d() {
        if (this.f2164d != null) {
            LocalBroadcastManagerUtils.getInstance(this).unregisterReceiver(this.f2164d);
            this.f2164d = null;
        }
        if (this.f2165e != null) {
            LocalBroadcastManagerUtils.getInstance(this).unregisterReceiver(this.f2165e);
            this.f2165e = null;
        }
    }

    public final void a(Runnable runnable) {
        this.f2166f.removeCallbacks(runnable);
    }

    public boolean a() {
        return false;
    }

    public final void b(Runnable runnable) {
        this.f2166f.postDelayed(runnable, 5000L);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2166f = new a(this);
        if (this.f2164d == null) {
            this.f2164d = new RestartBiometricsBroadcast();
            LocalBroadcastManagerUtils.getInstance(this).registerReceiver(this.f2164d, new IntentFilter(ALBiometricsKeys.KEY_ACTION_RESTART_BIOMETRICS));
        }
        if (this.f2165e == null) {
            this.f2165e = new FinishBiometricsBroadcast();
            LocalBroadcastManagerUtils.getInstance(this).registerReceiver(this.f2165e, new IntentFilter(ALBiometricsKeys.KEY_ACTION_FINISH_BIOMETRICS));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f2164d != null) {
            LocalBroadcastManagerUtils.getInstance(this).unregisterReceiver(this.f2164d);
            this.f2164d = null;
        }
        if (this.f2165e != null) {
            LocalBroadcastManagerUtils.getInstance(this).unregisterReceiver(this.f2165e);
            this.f2165e = null;
        }
    }

    private static void a(Window window) {
        if (window != null && Build.VERSION.SDK_INT > 28) {
            try {
                View decorView = window.getDecorView();
                decorView.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(decorView, Boolean.FALSE);
            } catch (Throwable unused) {
            }
        }
    }

    public final String b() {
        return getResources().getConfiguration().orientation == 1 ? "竖屏" : "横屏";
    }
}
