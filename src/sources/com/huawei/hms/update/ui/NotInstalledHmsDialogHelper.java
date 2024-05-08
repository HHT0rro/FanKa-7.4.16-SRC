package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NotInstalledHmsDialogHelper {
    private static void a(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
    }

    public static String getAppName(Activity activity) {
        return activity == null ? "" : a(activity, activity.getPackageName());
    }

    public static int getConfirmResId(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        a(activity);
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }

    public static AlertDialog.Builder getDialogBuilder(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        a(activity);
        return new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity)).setMessage(activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{a(activity, activity.getPackageName())}));
    }

    private static String a(Context context, String str) {
        if (context == null) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
            return "";
        }
    }
}
