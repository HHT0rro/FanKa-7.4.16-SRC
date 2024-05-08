package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wangmai.common.utils.ConstantInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WXUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appz {

    /* renamed from: appa, reason: collision with root package name */
    private static boolean f46871appa = false;
    private static IWXAPI appb;

    private static boolean appa(Context context) {
        if (!f46871appa) {
            if (TextUtils.isEmpty(ConstantInfo.getWxAppId())) {
                appa.appa.appf.appd.appe("WXUtils", "WxAppId is empty");
            } else {
                appa.appa.appf.appd.appa("WXUtils", "WxAppId:" + ConstantInfo.getWxAppId());
                appb = WXAPIFactory.createWXAPI(context, ConstantInfo.getWxAppId());
                f46871appa = true;
            }
        }
        return f46871appa;
    }

    public static boolean appa(Context context, String str, String str2) {
        try {
            appa.appa.appf.appd.appa("WXUtils", "appletId:" + str + " path:" + str2);
            if (!appa(context) || !appa()) {
                return false;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str;
            if (!TextUtils.isEmpty(str2)) {
                req.path = str2;
            }
            req.miniprogramType = 0;
            return appb.sendReq(req);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WXUtils", "launchApplet error:" + th.toString());
            return false;
        }
    }

    private static boolean appa() {
        appa.appa.appf.appd.appa("WXUtils", "isWXAppInstalled:" + appb.isWXAppInstalled() + "\tgetWXAppSupportAPI:" + appb.getWXAppSupportAPI() + "[target 620757000]");
        return appb.isWXAppInstalled() && appb.getWXAppSupportAPI() >= 620757000;
    }
}
