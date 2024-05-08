package com.huawei.appgallery.agd.serverreq.utils.device;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.utils.PropertyUtil;
import com.huawei.hms.android.SystemUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DeviceUtil {
    public static String getBrand() {
        String prop = PropertyUtil.getProp(SystemUtils.PRODUCT_BRAND);
        return TextUtils.isEmpty(prop) ? "" : prop;
    }

    public static String getBuildVersion() {
        try {
            Object obj = Class.forName("com.huawei.system.BuildEx").getField("DISPLAY").get(null);
            return obj == null ? Build.DISPLAY : obj.toString();
        } catch (Exception unused) {
            return Build.DISPLAY;
        }
    }

    public static String getDeviceModel() {
        String prop = PropertyUtil.getProp("ro.product.hw_model");
        return TextUtils.isEmpty(prop) ? Build.MODEL : prop;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }
}
