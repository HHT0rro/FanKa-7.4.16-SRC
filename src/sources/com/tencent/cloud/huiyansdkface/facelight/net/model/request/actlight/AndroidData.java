package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

import android.os.Build;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AndroidData {
    public float lux = 0.0f;
    public String build_brand = Build.BRAND;
    public String build_model = Param.getDeviceModel();
    public String build_hardware = Build.HARDWARE;
    public String build_display = Build.DISPLAY;
    public String build_product = Build.PRODUCT;
    public String build_device = Build.DEVICE;
    public String android_apilevel = "" + Build.VERSION.SDK_INT;
    public String android_version = Build.VERSION.RELEASE;

    public String toString() {
        return "AndroidData{lux=" + this.lux + ", build_brand='" + this.build_brand + "', build_model='" + this.build_model + "', build_hardware='" + this.build_hardware + "', build_display='" + this.build_display + "', build_product='" + this.build_product + "', build_device='" + this.build_device + "', android_apilevel='" + this.android_apilevel + "', android_version='" + this.android_version + "'}";
    }
}
