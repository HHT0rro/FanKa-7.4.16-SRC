package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AppStoreUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.CharSequence] */
    public static HashMap<String, String> getInstalledMarketPackageName(Context context) {
        String str;
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("market://details?id="));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            int size = queryIntentActivities.size();
            for (int i10 = 0; i10 < size; i10++) {
                try {
                    ActivityInfo activityInfo = queryIntentActivities.get(i10).activityInfo;
                    str = activityInfo.packageName;
                    try {
                        ?? loadLabel = activityInfo.loadLabel(context.getPackageManager());
                        try {
                            context.getResources().getString(context.getPackageManager().getPackageInfo(str, 0).applicationInfo.labelRes);
                            str2 = loadLabel;
                        } catch (Exception unused) {
                            str2 = loadLabel;
                        }
                    } catch (Exception unused2) {
                        str2 = "";
                    }
                } catch (Exception unused3) {
                    String str3 = "";
                    str = str3;
                    str2 = str3;
                }
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(str2.toString(), str);
                }
            }
        }
        return hashMap;
    }

    public static boolean toMarket(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.addFlags(268435456);
        if (str2 != null) {
            intent.setPackage(str2);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
