package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    public static int gA() {
        return a.qG.getValue().intValue();
    }

    public static boolean gB() {
        return a.qH.getValue().booleanValue();
    }

    public static boolean gC() {
        return a.qI.getValue().intValue() == 1 || a.qI.getValue().intValue() == 3;
    }

    public static boolean gD() {
        return a.qJ.getValue().booleanValue();
    }

    public static boolean gE() {
        return a.qK.getValue().booleanValue();
    }

    public static int gp() {
        return a.qt.getValue().intValue();
    }

    public static String gq() {
        return a.qx.getValue();
    }

    public static int gr() {
        return a.qu.getValue().intValue();
    }

    public static boolean gs() {
        return a.qw.getValue().booleanValue();
    }

    public static int gt() {
        return a.qv.getValue().intValue();
    }

    private static boolean gu() {
        return a.qz.getValue().intValue() == 1;
    }

    public static float gv() {
        return a.qE.getValue().floatValue();
    }

    public static boolean gw() {
        return a.qE.getValue().floatValue() > 0.0f && a.qE.getValue().floatValue() < 1.0f;
    }

    public static boolean gx() {
        return a.qF.getValue().booleanValue();
    }

    public static long gy() {
        return a.qC.getValue().intValue();
    }

    public static int gz() {
        return a.qD.getValue().intValue();
    }

    public static boolean i(AdInfo adInfo) {
        return !j(adInfo) && com.kwad.sdk.core.response.b.a.cJ(adInfo) && gu();
    }

    public static boolean j(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cJ(adInfo) && a.qB.getValue().intValue() == 1;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }
}
