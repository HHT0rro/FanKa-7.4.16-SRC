package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.component.AudioSettingComponent;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import java.util.Locale;

/* compiled from: MediaSystemComponent.java */
@m
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k extends h {

    /* renamed from: d, reason: collision with root package name */
    public y f2304d;

    /* compiled from: MediaSystemComponent.java */
    /* renamed from: com.alibaba.security.biometrics.build.k$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2305a;

        static {
            int[] iArr = new int[ABDetectType.values().length];
            f2305a = iArr;
            try {
                iArr[ABDetectType.BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2305a[ABDetectType.BLINK_STILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2305a[ABDetectType.MOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2305a[ABDetectType.MOUTH_STILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2305a[ABDetectType.POS_PITCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2305a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2305a[ABDetectType.PITCH_STILL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2305a[ABDetectType.POS_PITCH_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2305a[ABDetectType.POS_YAW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2305a[ABDetectType.YAW_STILL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void a(Activity activity) {
        try {
            if (this.f2304d == null) {
                this.f2304d = new aa(activity);
            }
        } catch (Exception unused) {
        }
    }

    private static a b(ABDetectType aBDetectType) {
        switch (AnonymousClass1.f2305a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return a.BLINK;
            case 3:
            case 4:
                return a.MOUTH;
            case 5:
            case 6:
            case 7:
                return a.POS_PITCH_DOWN;
            case 8:
                return a.POS_PITCH_UP;
            case 9:
            case 10:
                return a.POS_YAW;
            default:
                return null;
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean c() {
        y yVar = this.f2304d;
        if (yVar != null) {
            yVar.b();
            this.f2304d = null;
        }
        return super.c();
    }

    public final void d() {
        y yVar = this.f2304d;
        if (yVar != null) {
            yVar.a();
        }
    }

    public final void a(boolean z10) {
        y yVar = this.f2304d;
        if (yVar != null) {
            yVar.a(z10);
        }
    }

    /* compiled from: MediaSystemComponent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        BLINK("rp_face_blink"),
        MOUTH("rp_face_open_mouth"),
        POS_PITCH_DOWN("rp_face_pitch_up"),
        POS_PITCH_UP("rp_face_pitch_up"),
        POS_YAW("rp_face_yaw_left_right"),
        DING("rp_face_ding");

        public String resourceName;

        a(String str) {
            this.resourceName = str;
        }

        private int a(Context context) {
            Resources resources = context.getResources();
            String str = this.resourceName;
            if (!Locale.getDefault().getLanguage().equals(Locale.CHINA.getLanguage())) {
                str = str + "_" + Locale.getDefault().getLanguage();
            }
            return resources.getIdentifier(str, "raw", context.getPackageName());
        }

        private static String a(String str) {
            if (Locale.getDefault().getLanguage().equals(Locale.CHINA.getLanguage())) {
                return str;
            }
            return str + "_" + Locale.getDefault().getLanguage();
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        try {
            if (this.f2304d == null) {
                this.f2304d = new aa(activity);
            }
        } catch (Exception unused) {
        }
        a(((AudioSettingComponent) l.a(AudioSettingComponent.class)).f2419d);
        return false;
    }

    public final void a(ABDetectType aBDetectType) {
        y yVar;
        a aVar;
        y yVar2;
        if (aBDetectType == ABDetectType.AIMLESS || (yVar = this.f2304d) == null || yVar.d()) {
            return;
        }
        switch (AnonymousClass1.f2305a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                aVar = a.BLINK;
                break;
            case 3:
            case 4:
                aVar = a.MOUTH;
                break;
            case 5:
            case 6:
            case 7:
                aVar = a.POS_PITCH_DOWN;
                break;
            case 8:
                aVar = a.POS_PITCH_UP;
                break;
            case 9:
            case 10:
                aVar = a.POS_YAW;
                break;
            default:
                aVar = null;
                break;
        }
        if (aVar == null || (yVar2 = this.f2304d) == null) {
            return;
        }
        yVar2.a(aVar);
    }
}
