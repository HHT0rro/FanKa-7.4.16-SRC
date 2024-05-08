package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l {
    public static long aOE = -1;

    public static void ej(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = aOE;
            adTemplate.mOutClickTimeParam = aOE;
        }
    }

    public static void ek(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void el(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long em(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j10 = adTemplate.mOutClickTimeParam;
        return j10 > 0 ? j10 : adTemplate.mVisibleTimeParam;
    }
}
