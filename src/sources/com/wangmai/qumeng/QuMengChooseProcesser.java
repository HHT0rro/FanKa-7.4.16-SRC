package com.wangmai.qumeng;

import android.content.Context;
import appa.appa.appa.appa;
import appa.appa.appf.appd;
import com.alimm.tanx.core.constant.TanxAdType;
import com.wangmai.qumeng.processer.QuMWMInterstitialProcesser;
import com.wangmai.qumeng.processer.QuMWMNativeExpressProcesser;
import com.wangmai.qumeng.processer.QuMWMNativePotProcesser;
import com.wangmai.qumeng.processer.QuMWMRewardVideoProcesser;
import com.wangmai.qumeng.processer.QuMWMSplashProccesser;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class QuMengChooseProcesser {
    private static final String TAG = "QuMengChooseProcesser";

    public static appa getCheckSdkProgress(Context context, String str) {
        appa quMWMNativePotProcesser;
        try {
            if ("splash".equals(str)) {
                quMWMNativePotProcesser = new QuMWMSplashProccesser(context);
            } else if (TanxAdType.REWARD_STRING.equals(str)) {
                quMWMNativePotProcesser = new QuMWMRewardVideoProcesser(context);
            } else if ("popad".equals(str)) {
                quMWMNativePotProcesser = new QuMWMInterstitialProcesser(context);
            } else if ("nativeExpress".equals(str)) {
                quMWMNativePotProcesser = new QuMWMNativeExpressProcesser(context);
            } else if ("nativead".equals(str)) {
                quMWMNativePotProcesser = new QuMWMNativePotProcesser(context);
            } else {
                appd.appb(TAG, "[mq.mw] choose processor failed! type=" + str + ",未定义的广告类型,请联系我们");
                return null;
            }
            return quMWMNativePotProcesser;
        } catch (Throwable th) {
            appd.appb(TAG, "[mq.mw] choose processor failed! type=" + str + "," + th);
            return null;
        }
    }
}
