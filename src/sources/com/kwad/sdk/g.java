package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    public static String bU(String str) {
        return str + "/rest/e/system/speed";
    }

    public static String xV() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.DU().W("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String xW() {
        return xV() + "/rest/e/v3/open/univ";
    }

    public static String xX() {
        return xV() + "/rest/e/v4/open/univ";
    }

    public static String xY() {
        return xV() + "/rest/e/v4/open/univ/bidding";
    }

    public static String xZ() {
        return xV() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String ya() {
        return xV() + "/rest/e/v3/open/logBatch";
    }

    public static String yb() {
        return xV() + "/rest/e/v3/open/config";
    }

    public static String yc() {
        return xV() + "/rest/e/v3/open/callback";
    }

    public static String yd() {
        return xV() + "/rest/e/v3/open/crashLog";
    }

    public static String ye() {
        return xV() + "/rest/e/v3/open/appCheck";
    }

    public static String yf() {
        return xV() + "/rest/e/v3/open/collect";
    }

    public static String yg() {
        return xV() + "/rest/e/v3/open/checkReward";
    }

    public static String yh() {
        return xV() + "/rest/e/v3/open/kwaiGeoLocation";
    }
}
