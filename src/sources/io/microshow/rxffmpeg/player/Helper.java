package io.microshow.rxffmpeg.player;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Helper {
    private static long lastClickTime;

    public static ViewGroup getDecorView(Context context) {
        Activity scanForActivity = scanForActivity(context);
        if (scanForActivity == null) {
            return null;
        }
        return (ViewGroup) scanForActivity.getWindow().getDecorView();
    }

    public static int getFullScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        scanForActivity(context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void hideSysBar(Activity activity, ViewGroup viewGroup) {
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 2 | 4096);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static synchronized boolean isFastClick() {
        synchronized (Helper.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < 1000) {
                return true;
            }
            lastClickTime = currentTimeMillis;
            return false;
        }
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String secdsToDateFormat(int i10, int i11) {
        String str;
        String str2;
        long j10 = i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        long j11 = (i10 % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60;
        long j12 = i10 % 60;
        String str3 = "00";
        if (j10 <= 0) {
            str = "00";
        } else if (j10 < 10) {
            str = "0" + j10;
        } else {
            str = j10 + "";
        }
        if (j11 <= 0) {
            str2 = "00";
        } else if (j11 < 10) {
            str2 = "0" + j11;
        } else {
            str2 = j11 + "";
        }
        if (j12 > 0) {
            if (j12 < 10) {
                str3 = "0" + j12;
            } else {
                str3 = j12 + "";
            }
        }
        if (i11 >= 3600) {
            return str + u.bD + str2 + u.bD + str3;
        }
        return str2 + u.bD + str3;
    }

    public static ViewGroup setFullScreen(Context context, boolean z10) {
        Activity scanForActivity = scanForActivity(context);
        ViewGroup decorView = getDecorView(scanForActivity);
        if (decorView == null) {
            return null;
        }
        if (z10) {
            hideSysBar(scanForActivity, decorView);
            scanForActivity.setRequestedOrientation(0);
        } else {
            showSysBar(scanForActivity, decorView);
            scanForActivity.setRequestedOrientation(1);
        }
        return decorView;
    }

    public static void showSysBar(Activity activity, ViewGroup viewGroup) {
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-3) & (-4097));
        activity.getWindow().clearFlags(1024);
    }

    public static ViewGroup getDecorView(Activity activity) {
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }
}
