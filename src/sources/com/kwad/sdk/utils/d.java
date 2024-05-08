package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private static final Map<String, String> aOe;

    static {
        HashMap hashMap = new HashMap();
        aOe = hashMap;
        hashMap.put("HUAWEI", com.huawei.openalliance.ad.constant.u.W);
        hashMap.put("OPPO", "com.oppo.market");
        hashMap.put(ADEvent.VIVO, "com.bbk.appstore");
        hashMap.put(ADEvent.XIAOMI, "com.xiaomi.market");
        hashMap.put("OnePlus", "com.oppo.market");
        hashMap.put("Meizu", "com.meizu.mstore");
        hashMap.put("samsung", "com.sec.android.app.samsungapps");
        hashMap.put("SMARTISAN", "com.smartisanos.appstore");
        hashMap.put("Realme", "com.oppo.market");
        hashMap.put("HONOR", com.huawei.openalliance.ad.constant.u.W);
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        return at.Me() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4 && com.kwad.sdk.core.download.a.b.a(context, str, new b.C0523b() { // from class: com.kwad.sdk.utils.d.1
            @Override // com.kwad.sdk.core.download.a.b.C0523b, com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                super.onError(th);
                com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bn.t(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.C0523b, com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                super.onStart();
                com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
            }

            @Override // com.kwad.sdk.core.download.a.b.C0523b, com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                super.onSuccess();
                AdTemplate adTemplate2 = AdTemplate.this;
                adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                adTemplate2.mClickOpenAppStore = true;
                com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
            }
        }) == 1;
    }

    private static boolean gq(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }

    public static boolean h(Context context, AdTemplate adTemplate) {
        String str;
        String str2;
        int i10;
        Intent intent;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String cQ = com.kwad.sdk.core.response.b.a.cQ(dQ);
        String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
        if (context != null && !TextUtils.isEmpty(cQ)) {
            try {
                String str3 = Build.BRAND;
                if ("samsung".equals(str3)) {
                    cQ = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ay;
                }
                String str4 = aOe.get(str3);
                try {
                    com.kwad.sdk.commercial.b.a.a(adTemplate, cQ, str4, 1, 0);
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(cQ));
                    intent.addFlags(268435456);
                    for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                        if (!a(resolveInfo)) {
                            String str5 = resolveInfo.activityInfo.packageName;
                            if (str5.equals(str4) || gq(str5)) {
                                intent.setComponent(new ComponentName(str5, resolveInfo.activityInfo.name));
                                context.startActivity(intent);
                                adTemplate.mClickOpenAppStore = true;
                                com.kwad.sdk.commercial.b.a.b(adTemplate, cQ, str4, 1, 0);
                                return true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str4;
                    str = cQ;
                    i10 = 1;
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, str2, i10, 0, bn.t(th));
                    return false;
                }
                try {
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, cQ, str4, 0, 0);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str4;
                    str = cQ;
                    i10 = 0;
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, str2, i10, 0, bn.t(th));
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                str = cQ;
                str2 = null;
            }
        }
        return false;
    }

    private static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }
}
