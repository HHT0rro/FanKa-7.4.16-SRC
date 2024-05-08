package com.alibaba.security.realidentity.activity;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.utils.notch.HwNotchUtils;
import com.alibaba.security.biometrics.utils.notch.XiaomiNotchUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.SystemUtils;
import com.alibaba.security.realidentity.ErrorCode;
import com.alibaba.security.realidentity.R;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.b;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RpLoadingActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2988a = "key_verify_token";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2989b = "RpLoadingActivity";

    /* renamed from: c, reason: collision with root package name */
    private String f2990c;

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        b bVar = j.a.f3944a.f3899i;
        if (bVar != null) {
            bVar.onFinish(RPResult.AUDIT_NOT, new ErrorCode("-1", "-1", "onCancel"));
        }
        j.a.f3944a.b();
    }

    private void c() {
        a(TrackLog.createSdkLoadingExitLog());
    }

    private void d() {
        a(TrackLog.createSdkLoadingEnterLog(""));
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
        } catch (Exception e2) {
            RPLogging.e(f2989b, e2);
        }
    }

    private void f() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        b();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            requestWindowFeature(1);
            super.onCreate(bundle);
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
            } catch (Exception e2) {
                RPLogging.e(f2989b, e2);
            }
            if (Build.VERSION.SDK_INT != 26) {
                setRequestedOrientation(1);
            }
            getWindow().setBackgroundDrawableResource(R.drawable.rpsdk_face_win_bg_1);
            getWindow().addFlags(128);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.rp_face_loading_activity);
            this.f2990c = getIntent().getStringExtra(f2988a);
            a(TrackLog.createSdkLoadingEnterLog(""));
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.rp_loading_pb);
            if (progressBar != null) {
                progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.rpsdk_loading_bg), PorterDuff.Mode.SRC_ATOP);
            }
            ((ImageView) findViewById(R.id.rp_loading_close_iv)).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RpLoadingActivity.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RpLoadingActivity.b();
                    RpLoadingActivity.this.finish();
                }
            });
            final Handler handler = new Handler(Looper.getMainLooper());
            j.a.f3944a.f3909s = new p() { // from class: com.alibaba.security.realidentity.activity.RpLoadingActivity.2
                @Override // com.alibaba.security.realidentity.build.p
                public final void a() {
                }

                @Override // com.alibaba.security.realidentity.build.p
                public final void b() {
                    handler.postDelayed(new Runnable() { // from class: com.alibaba.security.realidentity.activity.RpLoadingActivity.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RpLoadingActivity.this.finish();
                        }
                    }, 150L);
                }
            };
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a(TrackLog.createSdkLoadingExitLog());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    private void a(TrackLog trackLog) {
        trackLog.setVerifyToken(this.f2990c);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        RPTrack.t(trackLog);
        RPTrack.uploadNow();
    }
}
