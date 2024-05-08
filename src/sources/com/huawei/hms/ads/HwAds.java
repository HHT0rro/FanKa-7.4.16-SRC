package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwAds {
    private HwAds() {
    }

    @GlobalApi
    public static int getAppActivateStyle() {
        return j.Code().C();
    }

    @GlobalApi
    public static RequestOptions getRequestOptions() {
        return j.Code().I();
    }

    @GlobalApi
    public static String getSDKVersion() {
        return j.Code().V();
    }

    @GlobalApi
    public static void init(Context context) {
        init(context, null);
    }

    @GlobalApi
    public static void init(Context context, String str) {
        j.Code().Code(context, str);
    }

    @GlobalApi
    public static boolean isAppInstalledNotify() {
        return j.Code().B();
    }

    @GlobalApi
    public static void setAppActivateStyle(int i10) {
        j.Code().V(i10);
    }

    @GlobalApi
    public static void setAppInstalledNotify(boolean z10) {
        j.Code().V(z10);
    }

    @GlobalApi
    public static void setBrand(int i10) {
        j.Code().Code(i10);
    }

    @GlobalApi
    public static void setConsent(String str) {
        j.Code().Code(str);
    }

    @GlobalApi
    public static void setRequestOptions(RequestOptions requestOptions) {
        j.Code().Code(requestOptions);
    }

    @GlobalApi
    public static void setVideoMuted(boolean z10) {
        j.Code().Code(z10);
    }

    @GlobalApi
    public static void setVideoVolume(float f10) {
        j.Code().Code(f10);
    }
}
