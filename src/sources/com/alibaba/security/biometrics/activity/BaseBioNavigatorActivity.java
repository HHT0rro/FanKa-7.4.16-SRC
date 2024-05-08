package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.ak;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.biometrics.utils.notch.HwNotchUtils;
import com.alibaba.security.biometrics.utils.notch.XiaomiNotchUtils;
import com.alibaba.security.common.utils.SystemUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseBioNavigatorActivity extends BaseAlBioActivity {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2173a = "BaseActivity";

    /* renamed from: g, reason: collision with root package name */
    public static final int f2174g = 10002;

    /* renamed from: h, reason: collision with root package name */
    public static final int f2175h = 10004;

    /* renamed from: i, reason: collision with root package name */
    public static final int f2176i = 10005;

    /* renamed from: j, reason: collision with root package name */
    public static final int f2177j = 10009;

    /* renamed from: k, reason: collision with root package name */
    public static final int f2178k = 10010;

    /* renamed from: l, reason: collision with root package name */
    public static final int f2179l = 10012;

    /* renamed from: m, reason: collision with root package name */
    public static final int f2180m = 10013;

    /* renamed from: n, reason: collision with root package name */
    public static final int f2181n = 20002;

    /* renamed from: o, reason: collision with root package name */
    public static final int f2182o = 20003;

    /* renamed from: p, reason: collision with root package name */
    public static final int f2183p = 20004;

    /* renamed from: q, reason: collision with root package name */
    public static final int f2184q = 20005;

    /* renamed from: r, reason: collision with root package name */
    public static final int f2185r = 20006;

    /* renamed from: s, reason: collision with root package name */
    public static final int f2186s = 20007;

    /* renamed from: t, reason: collision with root package name */
    public static final int f2187t = 20008;

    /* renamed from: u, reason: collision with root package name */
    public static TransitionMode f2188u;

    /* renamed from: com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2189a;

        static {
            int[] iArr = new int[TransitionMode.values().length];
            f2189a = iArr;
            try {
                iArr[TransitionMode.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2189a[TransitionMode.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2189a[TransitionMode.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2189a[TransitionMode.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2189a[TransitionMode.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(Activity activity, TransitionMode transitionMode) {
        if (transitionMode == null) {
            activity.overridePendingTransition(0, 0);
            return;
        }
        int i10 = AnonymousClass1.f2189a[transitionMode.ordinal()];
        if (i10 == 1) {
            activity.overridePendingTransition(0, 0);
            return;
        }
        if (i10 == 2) {
            activity.overridePendingTransition(R.anim.rp_anim_face_right_in, R.anim.rp_anim_face_right_out);
            return;
        }
        if (i10 == 3) {
            activity.overridePendingTransition(R.anim.rp_anim_face_left_in, R.anim.rp_anim_face_left_out);
        } else if (i10 == 4) {
            activity.overridePendingTransition(R.anim.rp_anim_face_bottom_in, R.anim.rp_anim_face_bottom_out);
        } else {
            if (i10 != 5) {
                return;
            }
            activity.overridePendingTransition(R.anim.rp_anim_face_top_in, R.anim.rp_anim_face_top_out);
        }
    }

    private void c() {
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

    private void d() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            a(this, f2188u);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        } catch (Exception unused) {
        }
        setVolumeControlStream(3);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        getWindow().setBackgroundDrawableResource(R.drawable.rpsdk_face_win_bg);
        getWindow().addFlags(128);
        getWindow().setFlags(1024, 1024);
        ak.b();
        ak.c();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ak.b();
        ak.c();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
