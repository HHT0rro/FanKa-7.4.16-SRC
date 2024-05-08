package com.wangmai.ad.dex.allmodules.appc;

import android.content.Context;
import appa.appa.appf.appd;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.mobads.sdk.api.IAdInterListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiChooseProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {
    public static appa.appa.appa.appa appa(Context context, String str) {
        appa.appa.appa.appa appbVar;
        char c4 = 65535;
        try {
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_BANNER)) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -934326481:
                    if (str.equals(TanxAdType.REWARD_STRING)) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -895866265:
                    if (str.equals("splash")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 106851892:
                    if (str.equals("popad")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 110066619:
                    if (str.equals("fullscreen")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 2029117273:
                    if (str.equals("nativeExpress")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 2045686394:
                    if (str.equals("nativead")) {
                        c4 = 1;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    appbVar = new com.wangmai.ad.dex.allmodules.api.splash.appb(context);
                    break;
                case 1:
                    appbVar = new com.wangmai.ad.dex.allmodules.appc.appc.appa(context);
                    break;
                case 2:
                    appbVar = new com.wangmai.ad.dex.allmodules.api.express.appb(context);
                    break;
                case 3:
                    appbVar = new com.wangmai.ad.dex.allmodules.appc.appd.appa(context);
                    break;
                case 4:
                    appbVar = new com.wangmai.ad.dex.allmodules.api.reward.appa(context);
                    break;
                case 5:
                    appbVar = new com.wangmai.ad.dex.allmodules.api.banner.appa(context);
                    break;
                case 6:
                    appbVar = new com.wangmai.ad.dex.allmodules.api.fullscreen.appa(context);
                    break;
                default:
                    Object[] objArr = new Object[2];
                    objArr[0] = "ApiChooseProcessor";
                    objArr[1] = "Api ChooseProcessor type = " + str + " failed:未定义的广告类型,请联系我们！";
                    appd.appb(objArr);
                    return null;
            }
            return appbVar;
        } catch (Throwable th) {
            appd.appb("ApiChooseProcessor", "Api ChooseProcessor type = " + str + " exception:" + th.toString());
            return null;
        }
    }
}
