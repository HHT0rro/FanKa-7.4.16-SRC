package com.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MdidSdkHelper {
    public static String TAG = "MdidSdkHelper";

    @Keep
    public static boolean _OuterIsOk = true;

    @Keep
    public String sdk_date = "20200702";

    @Keep
    public static int InitSdk(Context context, boolean z10, IIdentifierListener iIdentifierListener) {
        Object[] objArr = new Object[6];
        objArr[1] = context;
        objArr[2] = Boolean.valueOf(z10);
        objArr[3] = iIdentifierListener;
        objArr[4] = 28;
        objArr[5] = 1598952044250L;
        return ((Integer) Utils.rL(objArr)).intValue();
    }

    public static void logd(boolean z10, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = Boolean.valueOf(z10);
        objArr[2] = str;
        objArr[3] = 29;
        objArr[4] = 1598952044251L;
        Utils.rL(objArr);
    }

    public static void loge(boolean z10, Exception exc) {
        Object[] objArr = new Object[5];
        objArr[1] = Boolean.valueOf(z10);
        objArr[2] = exc;
        objArr[3] = 30;
        objArr[4] = 1598952044252L;
        Utils.rL(objArr);
    }
}
