package com.wangmai.tanx;

import android.content.Context;
import appa.appa.appa.appa;
import appa.appa.appf.appd;
import com.wangmai.tanx.processer.TanxWMNativeExpressProcesser;
import com.wangmai.tanx.processer.TanxWMNativePotProcesser;
import com.wangmai.tanx.processer.TanxWMSplashProccesser;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class TanxChooseProcesser {
    private static final String TAG = "TanxChooseProcesser";

    public static appa getCheckSdkProgress(Context context, String str) {
        appa tanxWMNativePotProcesser;
        try {
            if ("splash".equals(str)) {
                tanxWMNativePotProcesser = new TanxWMSplashProccesser(context);
            } else if ("nativeExpress".equals(str)) {
                tanxWMNativePotProcesser = new TanxWMNativeExpressProcesser(context);
            } else if ("nativead".equals(str)) {
                tanxWMNativePotProcesser = new TanxWMNativePotProcesser(context);
            } else {
                appd.appb(TAG, "[xt.mw] choose processor failed! type=" + str + ",未定义的广告类型,请联系我们");
                return null;
            }
            return tanxWMNativePotProcesser;
        } catch (Throwable th) {
            appd.appb(TAG, "[xt.mw] choose processor failed! type=" + str + "," + th);
            return null;
        }
    }
}
