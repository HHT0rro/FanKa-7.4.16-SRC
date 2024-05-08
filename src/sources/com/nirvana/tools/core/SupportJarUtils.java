package com.nirvana.tools.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SupportJarUtils {
    public static int checkSelfPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i10, String str, String str2) {
        ActivityCompat.startActivityForResult(activity, intent, i10, (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? null : ActivityOptionsCompat.makeCustomAnimation(activity, AppUtils.getAnimResID(activity, str), AppUtils.getAnimResID(activity, str2)).toBundle());
    }
}
