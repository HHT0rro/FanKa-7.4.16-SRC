package com.huawei.openalliance.ad.utils;

import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q {
    private static final String Code = "HagUtil";
    private static String I = "startAbilityByAbilityInfo";
    private static final String V = "com.huawei.hag.abilitykit.api.KitSdkManager";

    public static boolean Code() {
        return an.I(V);
    }

    public static boolean V() {
        if (Code()) {
            try {
                boolean canIUseApi = KitSdkManager.getInstance().canIUseApi(I);
                gl.V(Code, "can use api is %s", Boolean.valueOf(canIUseApi));
                return canIUseApi;
            } catch (Throwable th) {
                gl.V(Code, "isSupportFaApi exception %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }
}
