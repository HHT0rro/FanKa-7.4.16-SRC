package com.alibaba.security.biometrics.build;

import android.view.View;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* compiled from: ActionResourcesUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ac {

    /* compiled from: ActionResourcesUtils.java */
    /* renamed from: com.alibaba.security.biometrics.build.ac$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2213a;

        static {
            int[] iArr = new int[ABDetectType.values().length];
            f2213a = iArr;
            try {
                iArr[ABDetectType.BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2213a[ABDetectType.BLINK_STILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2213a[ABDetectType.MOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2213a[ABDetectType.MOUTH_STILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2213a[ABDetectType.POS_PITCH_UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2213a[ABDetectType.PITCH_STILL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2213a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2213a[ABDetectType.POS_YAW_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2213a[ABDetectType.POS_YAW_LEFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2213a[ABDetectType.POS_YAW.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2213a[ABDetectType.YAW_STILL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2213a[ABDetectType.NONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static String a(View view, ABDetectType aBDetectType) {
        if (aBDetectType == null) {
            return "";
        }
        switch (AnonymousClass1.f2213a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return view.getResources().getString(R.string.face_detect_action_blink);
            case 3:
            case 4:
                return view.getResources().getString(R.string.face_detect_action_mounth);
            case 5:
            case 6:
                return view.getResources().getString(R.string.face_detect_action_raise_head);
            case 7:
                return view.getResources().getString(R.string.face_detect_action_pitch_down_head);
            case 8:
                return view.getResources().getString(R.string.face_detect_action_turn_right);
            case 9:
                return view.getResources().getString(R.string.face_detect_action_turn_left);
            case 10:
            case 11:
                return view.getResources().getString(R.string.face_detect_action_turn_right_or_left);
            case 12:
            default:
                return "";
        }
    }

    private static int a(ABDetectType aBDetectType) {
        if (aBDetectType == null) {
            return -1;
        }
        switch (AnonymousClass1.f2213a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return R.drawable.rp_face_guide_blink_anim;
            case 3:
            case 4:
                return R.drawable.rp_face_guide_mouth_anim;
            case 5:
            case 6:
            case 7:
                return R.drawable.rp_face_guide_pitch_anim;
            case 8:
            case 9:
            case 10:
            case 11:
                return R.drawable.rp_face_guide_yaw_anim;
            default:
                return -1;
        }
    }
}
