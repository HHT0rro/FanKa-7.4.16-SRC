package com.jd.ad.sdk.jad_do;

import com.hailiang.advlib.core.ADEvent;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_kx {
    public static final String[] jad_an = {"huawei"};
    public static final String[] jad_bo = {ADEvent.XIAOMI};
    public static final String[] jad_cp = {"oppo"};
    public static final String[] jad_dq = {"oneplus"};
    public static final String[] jad_er = {"meizu"};

    public static boolean jad_an() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return IManufacturerDeviceInfo.OS_HARMONY.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }
}
