package com.huawei.appgallery.agd.base.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.util.ProviderUtil;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AppMarketApi {
    public static String getServiceCountry(@NonNull Context context) {
        return ProviderUtil.a(context, ProviderUtil.Item.HOME_COUNTRY);
    }

    public static String getSignature(@NonNull Context context) {
        if (!isAgreeProtocol(context)) {
            j9.a.f50348d.i("AppMarketApi", "getSignature not agree protocol return");
            return "";
        }
        if (!(l9.b.a(context, CoreServiceApi.getAppGalleryPkg(context)) >= 2)) {
            j9.a.f50348d.i("AppMarketApi", "getSignature version not support, return");
            return "";
        }
        return ProviderUtil.a(context, ProviderUtil.Item.SIGNATURE);
    }

    public static String getUdId(@NonNull Context context) {
        if (!isAgreeProtocol(context)) {
            j9.a.f50348d.i("AppMarketApi", "getUdId not agree protocol return");
            return "";
        }
        if (!(l9.b.a(context, CoreServiceApi.getAppGalleryPkg(context)) >= 2)) {
            j9.a.f50348d.i("AppMarketApi", "getUdId version not support, return");
            return "";
        }
        return ProviderUtil.a(context, ProviderUtil.Item.UD_ID);
    }

    public static boolean isAgreeProtocol(@NonNull Context context) {
        return Boolean.parseBoolean(ProviderUtil.a(context, ProviderUtil.Item.PROTOCOL));
    }

    public static Pair<Boolean, String> openFastApp(Activity activity, String str) {
        String str2 = BaseConstant.URI_PARAMS + str + "/";
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str2));
            intent.setPackage("com.huawei.fastapp");
            intent.setFlags(268435456);
            activity.startActivity(intent);
            return Pair.create(Boolean.TRUE, "open fast app success");
        } catch (Exception e2) {
            return Pair.create(Boolean.FALSE, "can not open fast app: " + e2.getMessage());
        }
    }

    public static Pair<Boolean, String> openNative(@NonNull Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return Pair.create(Boolean.FALSE, "intent is null");
        }
        try {
            if (!(context instanceof Activity)) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
            return Pair.create(Boolean.TRUE, "open NativeAd app success");
        } catch (Exception e2) {
            return Pair.create(Boolean.FALSE, "can not open download app: " + e2.getMessage());
        }
    }
}
