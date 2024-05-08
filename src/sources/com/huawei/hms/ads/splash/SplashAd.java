package com.huawei.hms.ads.splash;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.dy;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.q;
import com.huawei.openalliance.ad.inter.h;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.c;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.l;
import java.util.ArrayList;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SplashAd {
    private static int Z;

    private static int Code(Context context, int i10) {
        if (i10 != 0) {
            return (i10 == 1 || context == null || context.getResources().getConfiguration().orientation != 2) ? 1 : 0;
        }
        return 0;
    }

    public static void Code(Context context, String str, int i10, AdParam adParam, AdSlotParam.a aVar) {
        if (adParam == null || aVar == null) {
            return;
        }
        aVar.V(Z).I(c.Z(context)).Z(c.B(context)).Code(dy.Code(adParam.V())).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).I(adParam.I()).C(adParam.C());
        if (adParam.Code() != null) {
            aVar.Code(adParam.Code());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        aVar.Code(arrayList).Code(Code(context, i10));
    }

    @GlobalApi
    public static void dismissExSplashSlogan(final Context context) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(q.f32327j, null, null, null);
            }
        });
    }

    @GlobalApi
    public static boolean isExSplashEnable(Context context) {
        return c.L(context);
    }

    @GlobalApi
    public static void preloadAd(Context context, String str, int i10, AdParam adParam) {
        if (context == null || str == null) {
            return;
        }
        Z = l.I(context);
        h Code = com.huawei.openalliance.ad.inter.g.Code(context);
        if (Code instanceof com.huawei.openalliance.ad.inter.g) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(context, str, i10, adParam, aVar);
            ((com.huawei.openalliance.ad.inter.g) Code).I(aVar.S());
            Code.Code();
        }
    }

    @GlobalApi
    public static void setDefaultSplashMode(Context context, int i10) {
        com.huawei.openalliance.ad.inter.g.Code(context).C(i10);
    }

    @GlobalApi
    public static void setSloganShowTimeWhenNoAd(final Context context, final int i10) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(q.f32328k, String.valueOf(i10), null, null);
            }
        });
    }

    @GlobalApi
    public void dismissExSplash(final Context context) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(q.f32329l, null, null, null);
            }
        });
    }

    @GlobalApi
    public void setExSplashShowTime(final Context context, final int i10) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.4
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(q.f32330m, String.valueOf(i10), null, null);
            }
        });
    }
}
