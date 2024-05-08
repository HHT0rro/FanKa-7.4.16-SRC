package com.huawei.quickcard;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33601a = "QTimingFactory";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Interpolator a(String str) {
        char c4;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals(Attributes.AnimationTiming.EASE_IN)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1102672091:
                if (str.equals(Attributes.AnimationTiming.LINEAR)) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -789192465:
                if (str.equals(Attributes.AnimationTiming.EASE_OUT)) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -361990811:
                if (str.equals(Attributes.AnimationTiming.EASE_IN_OUT)) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 3105774:
                if (str.equals("ease")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 == 0) {
            return new b0();
        }
        if (c4 == 1) {
            return new z();
        }
        if (c4 == 2) {
            return new c0();
        }
        if (c4 != 3) {
            return new LinearInterpolator();
        }
        return new a0();
    }
}
