package com.huawei.appgallery.agd.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.openalliance.ad.constant.t;
import j9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DeepLinkUtils {
    public static final String DEEPLINK_REFERRER = "referrer";
    public static final int FAIL_EXCEPTION = 1;
    public static final int SUCCESS = 0;

    @NonNull
    public static Pair<Integer, String> a(@NonNull Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setPackage(AgdManager.getAppGalleryPkgName(context));
            intent.setData(uri);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return Pair.create(0, "");
        } catch (Exception e2) {
            a.f50348d.e("DeepLinkUtils", " jumpAgPage error " + e2.getMessage());
            return Pair.create(1, " jumpAgPage error " + e2.getMessage());
        }
    }

    public static Uri buildUri(String str) {
        return new Uri.Builder().scheme(t.Code).authority("details").appendQueryParameter("id", str).appendQueryParameter("referrer", "agdprofastapp").build();
    }

    public static boolean jumpAgPage(@NonNull Context context, Uri uri) {
        return ((Integer) a(context, uri).first).intValue() == 0;
    }

    public static boolean jumpDeeplink(@NonNull Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            a.f50348d.e("DeepLinkUtils", " jumpDeeplink error " + e2.getMessage());
            return false;
        }
    }
}
