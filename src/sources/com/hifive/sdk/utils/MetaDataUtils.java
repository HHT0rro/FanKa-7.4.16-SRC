package com.hifive.sdk.utils;

import android.app.Activity;
import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MetaDataUtils {
    public static String getActivityMetaData(Activity activity, String str) {
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).metaData.getString("name");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getApplicationMetaData(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
