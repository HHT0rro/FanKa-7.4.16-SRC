package com.jd.ad.sdk.jad_do;

import java.text.DecimalFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_hu {
    public static String jad_an(double d10) {
        float log;
        double random = (float) Math.random();
        if (random <= 0.5d) {
            log = (float) (Math.log(1.0f - r0) * (-0.001f));
        } else {
            log = (float) (Math.log(random) * 0.001f);
        }
        try {
            return new DecimalFormat("0.000000").format(log + d10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "-1";
        }
    }
}
