package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsRuntime;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.o;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.ModelInitializedWidget;
import com.alibaba.security.biometrics.manager.ALBiometricsUiLifecycle;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.utils.notch.HwNotchUtils;
import com.alibaba.security.biometrics.utils.notch.NotchUtils;
import com.alibaba.security.biometrics.utils.notch.XiaomiNotchUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.DisplayUtils;
import com.alibaba.security.common.utils.SystemUtils;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALModelLoadingActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2147a = "com.alibaba.security.biometrics.activity.model_load";

    /* renamed from: b, reason: collision with root package name */
    public static final int f2148b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2149c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2150d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final String f2151e = "extra_progress";

    /* renamed from: f, reason: collision with root package name */
    public static final String f2152f = "extra_state";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2153g = "ALModelLoadingActivity";

    /* renamed from: k, reason: collision with root package name */
    private static final int f2154k = -4;

    /* renamed from: h, reason: collision with root package name */
    private ModelInitializedWidget f2155h;

    /* renamed from: i, reason: collision with root package name */
    private DetectActionResultWidget f2156i;

    /* renamed from: j, reason: collision with root package name */
    private ALBiometricsEventListener f2157j;

    /* renamed from: l, reason: collision with root package name */
    private final BroadcastReceiver f2158l = new BroadcastReceiver() { // from class: com.alibaba.security.biometrics.activity.ALModelLoadingActivity.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                RPLogging.w(ALModelLoadingActivity.f2153g, "Null intent found in receiver message");
                return;
            }
            int intExtra = intent.getIntExtra(ALModelLoadingActivity.f2152f, 0);
            if (intExtra == 0) {
                ALModelLoadingActivity.b(ALModelLoadingActivity.this);
                return;
            }
            if (intExtra == 1) {
                ALModelLoadingActivity.this.finish();
            } else {
                if (intExtra != 2) {
                    return;
                }
                ALModelLoadingActivity.a(ALModelLoadingActivity.this, intent.getIntExtra(ALModelLoadingActivity.f2151e, 0));
            }
        }
    };

    private void b() {
        ModelInitializedWidget modelInitializedWidget = this.f2155h;
        if (modelInitializedWidget != null) {
            modelInitializedWidget.h();
        }
    }

    private void d() {
        finish();
    }

    private void e() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (SystemUtils.isHuawei() && HwNotchUtils.hasNotch(this)) {
                HwNotchUtils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
            } else if (SystemUtils.isXiaomi() && XiaomiNotchUtils.hasNotch(this)) {
                XiaomiNotchUtils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ALBiometricsEventListener aLBiometricsEventListener = this.f2157j;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onCancel(-4, null);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        NetworkInfo activeNetworkInfo;
        requestWindowFeature(1);
        super.onCreate(bundle);
        WeakReference<ALBiometricsEventListener> weakReference = ALBiometricsRuntime.mALBiometricsEventListener;
        this.f2157j = weakReference != null ? weakReference.get() : null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (SystemUtils.isHuawei() && HwNotchUtils.hasNotch(this)) {
                HwNotchUtils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
            } else if (SystemUtils.isXiaomi() && XiaomiNotchUtils.hasNotch(this)) {
                XiaomiNotchUtils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
            }
        } catch (Exception unused) {
        }
        setContentView(R.layout.rp_face_model_load_activity);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.rp_activity_layout_model_load);
        this.f2155h = (ModelInitializedWidget) frameLayout.findViewById(R.id.widget_abfl_model_init);
        this.f2156i = (DetectActionResultWidget) frameLayout.findViewById(R.id.widget_abfl_detectactionresult);
        ImageView imageView = (ImageView) findViewById(R.id.rp_face_loading_back_iv);
        if (NotchUtils.getStatusBarHeight(this) > 0) {
            int dip2px = DisplayUtils.dip2px(this, 18.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px);
            layoutParams.setMargins(DisplayUtils.dip2px(this, 16.0f), NotchUtils.getStatusBarHeight(this) + DisplayUtils.dip2px(this, 3.0f), 0, 0);
            imageView.setLayoutParams(layoutParams);
        }
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT > 28) {
            try {
                View decorView = window.getDecorView();
                decorView.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(decorView, Boolean.FALSE);
            } catch (Throwable unused2) {
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        if (!((connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true)) {
            this.f2156i.a(20004, getResources().getString(R.string.face_init_net_connecting_error), getResources().getString(R.string.face_liveness_upload_fail_msg), getResources().getString(R.string.face_liveness_retry), false, GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
            this.f2156i.setOnDetectActionResultListener(new o() { // from class: com.alibaba.security.biometrics.activity.ALModelLoadingActivity.2
                @Override // com.alibaba.security.biometrics.build.o
                public final void a(int i10, int i11, int i12) {
                    if (ALModelLoadingActivity.this.f2157j != null) {
                        ALModelLoadingActivity.this.f2157j.onCancel(-4, null);
                    }
                    ALModelLoadingActivity.this.finish();
                }

                @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnBeforeRetryListener
                public final void onBeforeRetry(OnRetryListener onRetryListener, String str) {
                }
            });
            this.f2156i.setVisibility(0);
        } else {
            ModelInitializedWidget modelInitializedWidget = this.f2155h;
            if (modelInitializedWidget != null) {
                modelInitializedWidget.h();
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.activity.ALModelLoadingActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ALModelLoadingActivity.this.f2157j != null) {
                    ALModelLoadingActivity.this.f2157j.onCancel(-4, null);
                }
                ALModelLoadingActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ALBiometricsUiLifecycle.getInstance().setModelLoadingActivityActive(false);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f2158l);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        ALBiometricsEventListener aLBiometricsEventListener = this.f2157j;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBeforeRetry(new OnRetryListener() { // from class: com.alibaba.security.biometrics.activity.ALModelLoadingActivity.4
                @Override // com.alibaba.security.biometrics.service.listener.OnRetryListener
                public final void onRetry(int i10) {
                    ALModelLoadingActivity.this.finish();
                }
            }, null);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f2158l, new IntentFilter(f2147a));
        ALBiometricsUiLifecycle.getInstance().setModelLoadingActivityActive(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public static void a(Context context, ALBiometricsEventListener aLBiometricsEventListener) {
        ALBiometricsRuntime.mALBiometricsEventListener = new WeakReference<>(aLBiometricsEventListener);
        context.startActivity(new Intent(context, (Class<?>) ALModelLoadingActivity.class));
    }

    private void c() {
        ModelInitializedWidget modelInitializedWidget = this.f2155h;
        if (modelInitializedWidget == null || modelInitializedWidget.getVisibility() != 0) {
            return;
        }
        this.f2155h.i();
    }

    public static /* synthetic */ void b(ALModelLoadingActivity aLModelLoadingActivity) {
        ModelInitializedWidget modelInitializedWidget = aLModelLoadingActivity.f2155h;
        if (modelInitializedWidget == null || modelInitializedWidget.getVisibility() != 0) {
            return;
        }
        aLModelLoadingActivity.f2155h.i();
    }

    private void a(int i10) {
        ModelInitializedWidget modelInitializedWidget = this.f2155h;
        if (modelInitializedWidget == null || modelInitializedWidget.getVisibility() != 0) {
            return;
        }
        ModelInitializedWidget modelInitializedWidget2 = this.f2155h;
        modelInitializedWidget2.f2534c.setProgress(i10);
        modelInitializedWidget2.f2533b.setText(String.format(modelInitializedWidget2.getContext().getString(R.string.face_init_progress), Integer.valueOf(i10)));
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

    public static /* synthetic */ void a(ALModelLoadingActivity aLModelLoadingActivity, int i10) {
        ModelInitializedWidget modelInitializedWidget = aLModelLoadingActivity.f2155h;
        if (modelInitializedWidget == null || modelInitializedWidget.getVisibility() != 0) {
            return;
        }
        ModelInitializedWidget modelInitializedWidget2 = aLModelLoadingActivity.f2155h;
        modelInitializedWidget2.f2534c.setProgress(i10);
        modelInitializedWidget2.f2533b.setText(String.format(modelInitializedWidget2.getContext().getString(R.string.face_init_progress), Integer.valueOf(i10)));
    }
}
